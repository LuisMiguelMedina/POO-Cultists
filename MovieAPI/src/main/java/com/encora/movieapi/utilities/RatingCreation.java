package com.encora.movieapi.utilities;

import com.encora.movieapi.entities.Movies;
import com.encora.movieapi.entities.Ratings;
import com.encora.movieapi.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RatingCreation {
    private Movies movie;
    private Ratings rating;
    private User user;
    
    public RatingCreation(@JsonProperty("movies")Movies movie, @JsonProperty("ratings") Ratings rating, @JsonProperty("User") User user){
        this.movie = movie;
        this.rating = rating;
        this.user = user;
    }

    public Movies getMovie() {
        return movie;
    }

    public Ratings getRating() {
        return rating;
    }

    public User getUser() {
        return user;
    }

}
