package com.encora.movieapi.viewControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.encora.movieapi.entities.Movies;
import com.encora.movieapi.entities.Ratings;
import com.encora.movieapi.entities.Users;
import com.encora.movieapi.services.MoviesService;
import com.encora.movieapi.services.RatingsService;
import com.encora.movieapi.services.UserService;

@Controller
public class RatingViewController {

    @Autowired
    private MoviesService moviesService;

    @Autowired
    private UserService userService;

    @Autowired
    private RatingsService ratingsService;

    @GetMapping("/rating/new")
    public String viewCreateRating(Model model){
        Users user = new Users();
        Movies movie = new Movies();
        Ratings rating = new Ratings();
        rating.setUser(user);
        rating.setMovie(movie);
        model.addAttribute("rating", rating);
        return "new-rating";
    }

    @PostMapping("/rating/new")
    public String createRating(@ModelAttribute Ratings rating){
        Movies temporaryMovie = moviesService.getMovie(rating.getMovie().getName());
        Users temporaryUser = userService.getUser(rating.getUser().getUsername());
        rating.setMovie(temporaryMovie);
        rating.setUser(temporaryUser);
        ratingsService.createRating(rating);
        return "redirect:/movie/"+temporaryMovie.getMovieId();
    } 

}
