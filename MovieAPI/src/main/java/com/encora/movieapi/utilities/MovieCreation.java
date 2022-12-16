package com.encora.movieapi.utilities;

import com.encora.movieapi.entities.Movies;
import com.encora.movieapi.entities.Users;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieCreation {
    private Movies movie;
    private Users user;

    public MovieCreation(@JsonProperty("user") Users user, @JsonProperty("movie") Movies movie){
        this.movie = movie;
        this.user = user;        
    }

    public Movies getMovie(){
        return this.movie;
    }

    public Users getUser(){
        return this.user;
    }
}
