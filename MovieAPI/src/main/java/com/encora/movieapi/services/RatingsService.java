package com.encora.movieapi.services;

import com.encora.movieapi.Entities.Movies;
import com.encora.movieapi.Entities.Ratings;
import com.encora.movieapi.Entities.User;
import com.encora.movieapi.repositories.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public Ratings save(Ratings ratings){
        return ratingsRepository.save(ratings);
    }

    public void deleteRating(Long id){
        ratingsRepository.deleteById(id);
    }

    public void addMovie(Movies movie, Long id){
        ratingsRepository.addMovie(movie, id);
    }

    public void addUser(User user, Long id) {
        ratingsRepository.addUser(user, id);
    }
}
