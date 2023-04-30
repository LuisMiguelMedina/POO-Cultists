package com.encora.mx.restapi.controller;



import com.encora.mx.restapi.entity.Movie;
import com.encora.mx.restapi.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MovieController {


    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    //Get
    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.findAll();
    }

    @GetMapping("/movie/{params}")
    public Movie findByLocalDateAndName(@PathVariable(name = "params") Map<String, String> params){
        LocalDate dateMovie = LocalDate.parse(params.get("dateMovie"));
        String name = params.get("name");
        return movieService.findByDateMovieAndName(dateMovie, name);
    }

    @GetMapping("/{name}")
    public List<Movie> findAllByName(@PathVariable(name = "name") String name){
        return movieService.findAllMoviesByName(name);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createMovie(movie));
    }

    @DeleteMapping("/{params}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Movie> deleteMovieByNameAndMovieDate(@PathVariable Map<String, String> params){
        LocalDate movieDate =LocalDate.parse(params.get("movieDate"));
        String name = params.get("name");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(movieService.deleteMovieByNameAndDateMovie(movieDate, name));
    }
}
