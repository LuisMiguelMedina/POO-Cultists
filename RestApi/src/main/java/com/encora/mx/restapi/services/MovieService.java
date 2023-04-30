package com.encora.mx.restapi.services;


import com.encora.mx.restapi.entity.Movie;
import com.encora.mx.restapi.repository.MovieRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public Movie deleteMovieByNameAndDateMovie(LocalDate dateMovie, String name){
        Movie movieFound = movieRepository.findByDateMovieAndName(dateMovie, name);
        movieRepository.delete(movieFound);
        return movieFound;
    }

    public List<Movie> findAllMoviesByName(String name){
        return movieRepository.findAllByName(name);
    }

    public Movie findByDateMovieAndName(LocalDate dateMovie, String name){
        return movieRepository.findByDateMovieAndName(dateMovie, name);
    }
    public Movie createMovie(Movie movie){
        movie.setDatePage(LocalDate.now());
        return movieRepository.save(movie);
    }
}
