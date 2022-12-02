package com.encora.movieapi.services;

import com.encora.movieapi.Entities.Ratings;
import com.encora.movieapi.repositories.RaitingsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class RaitingsService {
    @Autowired
    RaitingsRepository raitingsRepository;

    public Optional<Ratings> findById(int id){
        return raitingsRepository.findById(id);
    }

    public List<Ratings> getAll(){
        return  raitingsRepository.findAll();
    }

    @Transactional
    public Ratings save(Ratings ratings){
        return raitingsRepository.save(ratings);
    }
}
