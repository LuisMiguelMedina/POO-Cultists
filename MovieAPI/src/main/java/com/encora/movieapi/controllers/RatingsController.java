
package com.encora.movieapi.controllers;

import com.encora.movieapi.entities.Movies;
import com.encora.movieapi.entities.Ratings;
import com.encora.movieapi.entities.Users;
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
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ratings createRating(@RequestBody RatingCreation ratingCreator){
        Ratings rating = ratingCreator.getRating();
        Movies movie = ratingCreator.getMovie();
        Users user = ratingCreator.getUser();
        Optional<Movies> optionalMovie = moviesService.getMovie(movie.getName());
        Optional<Users> optionalUser = userService.getUser(user.getUsername());
        ratingsService.createRating(rating);
        if(optionalMovie.isPresent()&&optionalUser.isPresent()){
            ratingsService.addMovie(optionalMovie.get(), rating.getRatingId());
            ratingsService.addUser(optionalUser.get(), rating.getRatingId());
        }
        return ratingsService.createRating(rating);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Ratings> updateRating(@PathVariable("id") Long id, @RequestBody Ratings ratings){
        Optional<Ratings> ratingsOptional = ratingsService.findById(id);
        if(ratingsOptional.isEmpty()) return ResponseEntity.notFound().build();
        
        Ratings ratingOptional = ratingsOptional.get();
        ratingOptional.setReview(ratings.getReview());
        ratingOptional.setSummary(ratings.getSummary());
        ratingOptional.setUpdateAt(LocalDateTime.now());
        ratingsService.updateRating(ratingOptional);

        return ResponseEntity.noContent().build();
    }
    //Delete
    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable Long id){
        ratingsService.deleteRating(id);
    }

    //ReadALL
    @GetMapping
    public List<Ratings> getAllRatings(){
        return ratingsService.getAll();
    }

    //ReadById

    @GetMapping("/{id}")
    public Ratings findByIdUser(@PathVariable Long id){
        Optional<Ratings> ratings = ratingsService.findById(id);
        return ratings.get();
    }
}
