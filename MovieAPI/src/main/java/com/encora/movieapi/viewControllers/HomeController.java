package com.encora.movieapi.viewControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.encora.movieapi.entities.Movies;
import com.encora.movieapi.services.MoviesService;

@Controller
public class HomeController {
    
    @Autowired
    private MoviesService moviesService;

    @GetMapping("/")
    public String getHomePage(Model model){
        List<Movies> moviesList = moviesService.getAll();
        model.addAttribute("movies", moviesList);
        for (Movies movies : moviesList) {
            model.addAttribute("user", movies.getUser());
        }
        return "home";
    }
}
