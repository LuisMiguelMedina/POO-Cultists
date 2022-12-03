package com.encora.movieapi.controllers;


import com.encora.movieapi.Entities.Ratings;
import com.encora.movieapi.repositories.RaitingsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RaitingsController {

    private final RaitingsRepository raitingsRepository;

    public RaitingsController(RaitingsRepository raitingsRepository) {
        this.raitingsRepository = raitingsRepository;
    }

    //Create
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Ratings createRating(@RequestBody Ratings ratings){
        return raitingsRepository.save(ratings);
    }

    //Update
    @PutMapping("update/{id}")
    public ResponseEntity<Ratings> updateRating(@PathVariable("id") int id, @RequestBody Ratings ratings){
        Optional<Ratings> ratingsOptional = raitingsRepository.findById(id);
        if(ratingsOptional.isEmpty()) return ResponseEntity.notFound().build();

        ratings.setRaintingId(id);
        raitingsRepository.save(ratings);

        return ResponseEntity.noContent().build();
    }
    //Delete
    @DeleteMapping("/delete/{id}")
    public void deleteRating(@PathVariable int id){
        raitingsRepository.deleteById(id);
    }

    //ReadALL
    @GetMapping("/allRatings")
    public List<Ratings> getAllRatings(){
        return raitingsRepository.findAll();
    }

    //ReadById

    @GetMapping("readId/{id}")
    public Ratings findByIdUser(@PathVariable int id){
        Optional<Ratings> ratings = raitingsRepository.findById(id);
        return ratings.get();
    }
}
