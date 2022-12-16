package com.encora.movieapi.services;

import com.encora.movieapi.entities.Movies;
import com.encora.movieapi.entities.Ratings;
import com.encora.movieapi.entities.Users;
import com.encora.movieapi.repositories.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RatingsService {
    @Autowired
    RatingsRepository ratingsRepository;

    public Optional<Ratings> findById(Long id){
        return ratingsRepository.findById(id);
    }

    public List<Ratings> getAll(){
        return  ratingsRepository.findAll();
    }

    @Transactional
    public Ratings createRating(Ratings ratings){
        ratings.setCreatedAt(LocalDateTime.now());
        ratings.setUpdateAt(LocalDateTime.now());
        return ratingsRepository.save(ratings);
    }

    @Transactional
    public Ratings updateRating(Ratings ratings){
        ratings.setUpdateAt(LocalDateTime.now());
        return ratingsRepository.save(ratings);
    }

    public void deleteRating(Long id){
        ratingsRepository.deleteById(id);
    }

    public void addMovie(Movies movie, Long id){
        ratingsRepository.addMovie(movie, id);
    }

    public void addUser(Users user, Long id) {
        ratingsRepository.addUser(user, id);
    }
}
