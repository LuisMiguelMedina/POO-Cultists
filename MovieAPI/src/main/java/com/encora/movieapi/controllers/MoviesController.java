package com.encora.movieapi.controllers;

import com.encora.movieapi.Entities.Ratings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Movies createMovie(@RequestBody String str) throws JsonMappingException, JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(str);
        User user = mapper.convertValue(node.get("user"), User.class);
        Movies movie = mapper.convertValue(node.get("movies"), Movies.class);
        movie.setUser(user);
        userRepository.save(user);
        return moviesRepository.save(movie);
    }

    //Update
    @PutMapping("update/{id}")
    public ResponseEntity<Movies> updateMovie(@PathVariable("id") int id, @RequestBody Movies movies){
        Optional<Movies> moviesOptional = moviesRepository.findById(id);
        if(moviesOptional.isEmpty()) return ResponseEntity.notFound().build();

        movies.setMovieId(id);
        moviesRepository.save(movies);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable int id){
        moviesRepository.deleteById(id);
    }

    //ReadAll
    @GetMapping("/allMovies")
    public List<Movies> getAllMovies(){
        return moviesRepository.findAll();
    }

    //ReadByID
    @GetMapping("readId/{id}")
    public Optional<Movies> getById(@PathVariable("id") int id){
        return moviesRepository.findById(id);
    }
}
