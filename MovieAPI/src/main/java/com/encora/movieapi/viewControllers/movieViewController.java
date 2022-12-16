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
import com.encora.movieapi.entities.Users;
import com.encora.movieapi.services.MoviesService;
import com.encora.movieapi.services.UserService;

@Controller
public class movieViewController {

    @Autowired
    private MoviesService moviesService;
    @Autowired
    private UserService userService;

    @GetMapping("/movie/{id}")
    public String getMovie(@PathVariable Long id, Model model){
        String response = "";
        Optional<Movies> optionalMovie = moviesService.getById(id);
        if (optionalMovie.isPresent()) {
            Movies movie = optionalMovie.get();
            model.addAttribute("movie", movie);
            model.addAttribute("user",movie.getUser());
            model.addAttribute("ratings", movie.getRatings());
            response = "movie";
        } else{
            response = "404";
        }
        return response;
    }

    @GetMapping("/movie/new")
    public String createNewMovie(Model model){
        Users user = userService.getUser("admin");
        Movies movie = new Movies();
        movie.setUser(user);
        model.addAttribute("movie", movie);
        return "new_movie";
    }

    @PostMapping("/movie/new")
    public String saveNewMovie(@ModelAttribute Movies movie){
        moviesService.movieCreate(movie);
        return "redirect:/movie/"+movie.getMovieId();
    }

}
