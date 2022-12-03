package com.encora.movieapi.utilities;

import com.encora.movieapi.Entities.Movies;
import com.encora.movieapi.Entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieCreation {
    private Movies movie;
    private User user;

    public MovieCreation(@JsonProperty("movies")Movies movie, @JsonProperty("users") User user) {
        this.movie = movie;
        this.user = user;
    }

    public Movies getMovie() {
        return movie;
    }

    public User getUser() {
        return user;
    }
}
