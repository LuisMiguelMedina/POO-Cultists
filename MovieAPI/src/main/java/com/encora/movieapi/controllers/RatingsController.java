package com.encora.movieapi.controllers;

import com.encora.movieapi.Entities.Movies;
import com.encora.movieapi.Entities.Ratings;
import com.encora.movieapi.Entities.User;
import com.encora.movieapi.services.MoviesService;
import com.encora.movieapi.services.RatingsService;
import com.encora.movieapi.services.UserService;
import com.encora.movieapi.utilities.RatingCreation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    private final RatingsService ratingsService;
    private final MoviesService moviesService;
    private final UserService userService;

    public RatingsController(RatingsService ratingsService, MoviesService moviesService, UserService userService) {
        this.ratingsService = ratingsService;
        this.moviesService = moviesService;
        this.userService = userService;
    }

    //Create
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Ratings createRating(@RequestBody RatingCreation ratingCreator){
        Ratings rating = ratingCreator.getRating();
        Movies movie = ratingCreator.getMovie();
        User user = ratingCreator.getUser();
        Movies optionalMovie = moviesService.getMovie(movie.getName());
        User optionalUser = userService.getUser(user.getUsername());
        ratingsService.save(rating);
        rating.setTime(LocalDateTime.now());
        ratingsService.addMovie(optionalMovie, rating.getRatingId());
        ratingsService.addUser(optionalUser, rating.getRatingId());
        return ratingsService.save(rating);
    }

    //Update
    @PutMapping("update/{id}")
    public ResponseEntity<Ratings> updateRating(@PathVariable("id") Long id, @RequestBody Ratings ratings){
        Optional<Ratings> ratingsOptional = ratingsService.findById(id);
        if(ratingsOptional.isEmpty()) return ResponseEntity.notFound().build();
        
        Ratings ratingOptional = ratingsOptional.get();
        ratingOptional.setReview(ratings.getReview());
        ratingOptional.setSummary(ratings.getSummary());
        ratingsService.save(ratingOptional);

        return ResponseEntity.noContent().build();
    }
    //Delete
    @DeleteMapping("/delete/{id}")
    public void deleteRating(@PathVariable Long id){
        ratingsService.deleteRating(id);
    }

    //ReadALL
    @GetMapping("/allRatings")
    public List<Ratings> getAllRatings(){
        return ratingsService.getAll();
    }

    //ReadById

    @GetMapping("readId/{id}")
    public Ratings findByIdUser(@PathVariable Long id){
        Optional<Ratings> ratings = ratingsService.findById(id);
        return ratings.get();
    }
}
