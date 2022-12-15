package com.encora.movieapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encora.movieapi.entities.Movies;
import com.encora.movieapi.entities.Users;
import com.encora.movieapi.repositories.MoviesRepository;

@Service
public class MoviesService {

    private final MoviesRepository moviesRepository;

    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public Optional<Movies> getById(Long ID){
        return moviesRepository.findById(ID);
    }

    public Movies getMovie(String name){
        return moviesRepository.getMovie(name);
    }

    public void addUser(Users user){
        moviesRepository.addUser(user);
    }

    public List<Movies> getAll(){
        return moviesRepository.findAll();
    }

    @Transactional
    public Movies save(Movies movie){
        return moviesRepository.save(movie);
    }

    public void deleteMovie(Long id){
        moviesRepository.deleteById(id);
    }
}
