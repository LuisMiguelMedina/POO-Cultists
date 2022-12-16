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

    @GetMapping("/movie/{id}/new_rating")
    public String viewCreateRating(@PathVariable Long id, Model model){
        Users user = new Users();
        Optional<Movies> movie = moviesService.getById(id);
        Ratings rating = new Ratings();
        rating.setUser(user);
        rating.setMovie(movie.get());
        model.addAttribute("rating", rating);
        return "new-rating";
    }

    @PostMapping("/movie/{id}/new_rating")
    public String createRating(@ModelAttribute Ratings rating){
        Optional<Users> temporaryUser = userService.getUser(rating.getUser().getUsername());
        rating.setUser(temporaryUser.get());
        ratingsService.createRating(rating);
        return "redirect:/movie/"+rating.getMovie().getMovieId();
    } 

}
