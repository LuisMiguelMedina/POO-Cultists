package com.encora.movieapi.utilities;

import com.encora.movieapi.entities.Movies;
import com.encora.movieapi.entities.Ratings;
import com.encora.movieapi.entities.Users;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RatingCreation {
    private Movies movie;
    private Ratings rating;
    private Users user;
    
    public RatingCreation(@JsonProperty("movies")Movies movie, @JsonProperty("ratings") Ratings rating, @JsonProperty("user") Users user){
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

    public Users getUser() {
        return user;
    }

}
