package com.encora.movieapi.viewControllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/rating/view")
    public String viewCreateRating(Model model){
        Users user = new Users();
        Movies movies = new Movies();
        Ratings rating = new Ratings();
        rating.setUser(user);
        rating.setMovie(movies);
        model.addAttribute("rating", rating);
        return "new-rating";
    }

    @PostMapping("/rating/view")
    public String createRating(@ModelAttribute Ratings rating){
        Optional<Users> temporaryUser = userService.getUser(rating.getUser().getUsername());
        Optional<Movies> movie = moviesService.getMovie(rating.getMovie().getName ());
        rating.setUser(temporaryUser.get());
        rating.setMovie(movie.get());
        ratingsService.createRating(rating);
        return "redirect:/movie/"+rating.getMovie().getMovieId();
    } 

}
