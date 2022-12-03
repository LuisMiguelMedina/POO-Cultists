package com.encora.movieapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.encora.movieapi.Entities.Movies;
import com.encora.movieapi.Entities.User;
import com.encora.movieapi.repositories.MoviesRepository;
import com.encora.movieapi.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/movies")
public class MoviesController{
    
    private final MoviesRepository moviesRepository;
    private final UserRepository userRepository;

    public MoviesController(MoviesRepository moviesRepository, UserRepository userRepository){
        this.moviesRepository = moviesRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Movies createMovie(@RequestBody String str) throws JsonMappingException, JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(str);
        User user = mapper.convertValue(node.get("user"), User.class);
        Movies movie = mapper.convertValue(node.get("movies"), Movies.class);
        movie.setUser(user);
        userRepository.save(user);
        return moviesRepository.save(movie);
    }
    
    @GetMapping("/all")
    public List<Movies> getAllMovies(){
        return moviesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Movies> getById(@PathVariable("id") int id){
        return moviesRepository.findById(id);
    }
}
