package com.encora.movieapi.controllers;


import com.encora.movieapi.Entities.Ratings;
import com.encora.movieapi.repositories.RaitingsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RaitingsController {

    private final RaitingsRepository raitingsRepository;

    public RaitingsController(RaitingsRepository raitingsRepository) {
        this.raitingsRepository = raitingsRepository;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Ratings createRating(@RequestBody Ratings ratings){
        return raitingsRepository.save(ratings);
    }

    @GetMapping("/allratings")
    public List<Ratings> getAllRatings(){
        return raitingsRepository.findAll();
    }
}
