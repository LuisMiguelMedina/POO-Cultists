package com.encora.movieapi.services;

import com.encora.movieapi.Entities.Raitings;
import com.encora.movieapi.repositories.RaitingsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class RaitingsService {
    @Autowired
    RaitingsRepository raitingsRepository;

    public Optional<Raitings> findById(int id){
        return raitingsRepository.findById(id);
    }

    public List<Raitings> getAll(){
        return  raitingsRepository.findAll();
    }

    @Transactional
    public Raitings save(Raitings raitings){
        return raitingsRepository.save(raitings);
    }
}
