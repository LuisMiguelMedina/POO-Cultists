package com.encora.movieapi.controllers;


import com.encora.movieapi.Entities.Ratings;
import com.encora.movieapi.services.RatingsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    private final RatingsService raitingsService;

    public RatingsController(RatingsService raitingsService) {
        this.raitingsService = raitingsService;
    }

    //Create
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Ratings createRating(@RequestBody Ratings ratings){
        return raitingsService.save(ratings);
    }

    //Update
    @PutMapping("update/{id}")
    public ResponseEntity<Ratings> updateRating(@PathVariable("id") Long id, @RequestBody Ratings ratings){
        Optional<Ratings> ratingsOptional = raitingsService.findById(id);
        if(ratingsOptional.isEmpty()) return ResponseEntity.notFound().build();

        ratings.setRaintingId(id);
        raitingsService.save(ratings);

        return ResponseEntity.noContent().build();
    }
    //Delete
    @DeleteMapping("/delete/{id}")
    public void deleteRating(@PathVariable Long id){
        raitingsService.deleteRating(id);
    }

    //ReadALL
    @GetMapping("/allRatings")
    public List<Ratings> getAllRatings(){
        return raitingsService.getAll();
    }

    //ReadById

    @GetMapping("readId/{id}")
    public Ratings findByIdUser(@PathVariable Long id){
        Optional<Ratings> ratings = raitingsService.findById(id);
        return ratings.get();
    }
}
