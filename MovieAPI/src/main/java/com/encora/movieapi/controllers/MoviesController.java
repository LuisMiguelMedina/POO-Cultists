package com.encora.movieapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.encora.movieapi.Entities.Movies;
import com.encora.movieapi.repositories.MoviesRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/")
public class MoviesController{
    
    private final MoviesRepository moviesRepository;

    public MoviesController(MoviesRepository moviesRepository){
        this.moviesRepository = moviesRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Movies createMovie(@RequestBody Movies movie){
        return moviesRepository.save(movie);
    }
    
    @GetMapping("/")
    public List<Movies> getAllMovies(){
        return moviesRepository.findAll();
    }
}
