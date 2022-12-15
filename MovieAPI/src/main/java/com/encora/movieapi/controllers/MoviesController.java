package com.encora.movieapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.encora.movieapi.entities.Movies;
import com.encora.movieapi.entities.Users;
import com.encora.movieapi.services.MoviesService;
import com.encora.movieapi.services.UserService;
import com.encora.movieapi.utilities.MovieCreation;

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
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movies createMovie(@RequestBody MovieCreation movieCreator){
        Movies movie = movieCreator.getMovie();
        Users temporaryUser = movieCreator.getUser();

        moviesService.save(movie);
        movie.setCreatedAt(LocalDateTime.now());
        movie.setUpdateAt(LocalDateTime.now());
        Users user = userService.getUser(temporaryUser.getUsername());
        moviesService.addUser(user);
        return moviesService.save(movie);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Movies> updateMovie(@PathVariable("id") Long id, @RequestBody Movies movies){
        Optional<Movies> moviesOptional = moviesService.getById(id);
        if(moviesOptional.isEmpty()) return ResponseEntity.notFound().build();
        Movies movieOptional = moviesOptional.get();
        movieOptional.setName(movies.getName());
        movieOptional.setReleaseYear(movies.getReleaseYear());
        movieOptional.setUpdateAt(LocalDateTime.now());
        moviesService.save(movieOptional);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id){
        moviesService.deleteMovie(id);
    }

    //ReadAll
    @GetMapping
    public List<Movies> getAllMovies(){
        return moviesService.getAll();
    }

    //ReadByID
    @GetMapping("/{id}")
    public Optional<Movies> getById(@PathVariable("id") Long id){
        return moviesService.getById(id);
    }
}
