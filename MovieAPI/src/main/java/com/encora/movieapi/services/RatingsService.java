package com.encora.movieapi.services;

import com.encora.movieapi.Entities.Ratings;
import com.encora.movieapi.repositories.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public void deleteUser(Long id){
        ratingsRepository.deleteById(id);
    }
}
