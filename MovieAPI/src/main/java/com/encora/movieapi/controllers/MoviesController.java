package com.encora.movieapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.encora.movieapi.Entities.Movies;
import com.encora.movieapi.Entities.User;
import com.encora.movieapi.services.MoviesService;
import com.encora.movieapi.services.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/movies")
public class MoviesController{
    
    private final MoviesService moviesService;
    private final UserService userService;

    public MoviesController(MoviesService moviesService, UserService userService){
        this.moviesService = moviesService;
        this.userService = userService;
    }

    //Create
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Movies createMovie(@RequestBody Movies movie){
        moviesService.save(movie);
        movie.setCreatedAt(LocalDateTime.now());
        movie.setUpdateAt(LocalDateTime.now());
        Optional<User> userOptional = userService.findById(Long.valueOf(1));
        User user = userOptional.get();
        moviesService.addUser(user);
        return moviesService.save(movie);
    }

    //Update
    @PutMapping("update/{id}")
    public ResponseEntity<Movies> updateMovie(@PathVariable("id") Long id, @RequestBody Movies movies){
        Optional<Movies> moviesOptional = moviesService.getById(id);
        if(moviesOptional.isEmpty()) return ResponseEntity.notFound().build();
        Movies movieOptional = moviesOptional.get();
        movieOptional.setName(movies.getName());
        movieOptional.setreleaseYear(movies.getreleaseYear());
        movieOptional.setUpdateAt(LocalDateTime.now());
        moviesService.save(movieOptional);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable Long id){
        moviesService.deleteMovie(id);
    }

    //ReadAll
    @GetMapping("/allMovies")
    public List<Movies> getAllMovies(){
        return moviesService.getAll();
    }

    //ReadByID
    @GetMapping("readId/{id}")
    public Optional<Movies> getById(@PathVariable("id") Long id){
        return moviesService.getById(id);
    }
}
