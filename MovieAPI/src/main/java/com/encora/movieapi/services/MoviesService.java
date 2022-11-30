package com.encora.movieapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.movieapi.Entities.Movies;
import com.encora.movieapi.repositories.MoviesRepository;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;

    public Optional<Movies> getById(int ID){
        return moviesRepository.findById(ID);
    }

    public List<Movies> getAll(){
        return moviesRepository.findAll();
    }

    public Movies save(Movies movie){
        return moviesRepository.save(movie);
    }
}
