package com.encora.movieapi.controllers;


import com.encora.movieapi.Entities.Raitings;
import com.encora.movieapi.repositories.RaitingsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.QuadCurve2D;
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
    public Raitings createRating(@RequestBody Raitings raitings){
        return raitingsRepository.save(raitings);
    }

    @GetMapping("/allratings")
    public List<Raitings> getAllRatings(){
        return raitingsRepository.findAll();
    }
}
