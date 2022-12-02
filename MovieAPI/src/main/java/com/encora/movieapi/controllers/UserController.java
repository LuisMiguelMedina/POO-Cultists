package com.encora.movieapi.controllers;

import com.encora.movieapi.Entities.User;
import com.encora.movieapi.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User createuser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/allusers")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}
