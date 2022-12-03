package com.encora.movieapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.encora.movieapi.Entities.Movies;
import com.encora.movieapi.Entities.User;
import com.encora.movieapi.repositories.MoviesRepository;
import com.encora.movieapi.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/movies")
public class MoviesController{
    
    private final MoviesRepository moviesRepository;
    private final UserRepository userRepository;

    public MoviesController(MoviesRepository moviesRepository, UserRepository userRepository){
        this.moviesRepository = moviesRepository;
        this.userRepository = userRepository;
    }

    //Create
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Movies createMovie(@RequestBody Movies movie){
        moviesRepository.save(movie);
        movie.setCreatedAt(LocalDateTime.now());
        movie.setUpdateAt(LocalDateTime.now());
        Optional<User> userOptional = userRepository.findById(Long.valueOf(1));
        User user = userOptional.get();
        moviesRepository.addUser(user);
        return moviesRepository.save(movie);
    }

    //Update
    @PutMapping("update/{id}")
    public ResponseEntity<Movies> updateMovie(@PathVariable("id") Long id, @RequestBody Movies movies){
        Optional<Movies> moviesOptional = moviesRepository.findById(id);
        if(moviesOptional.isEmpty()) return ResponseEntity.notFound().build();

        movies.setMovieId(id);
        moviesRepository.save(movies);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable Long id){
        moviesRepository.deleteById(id);
    }

    //ReadAll
    @GetMapping("/allMovies")
    public List<Movies> getAllMovies(){
        return moviesRepository.findAll();
    }

    //ReadByID
    @GetMapping("readId/{id}")
    public Optional<Movies> getById(@PathVariable("id") Long id){
        return moviesRepository.findById(id);
    }
}
