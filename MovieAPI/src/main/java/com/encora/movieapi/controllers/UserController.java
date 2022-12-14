package com.encora.movieapi.controllers;

import com.encora.movieapi.Entities.User;
import com.encora.movieapi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Create
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    //Update
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        Optional<User> userOptional = userService.findById(id);
        if(userOptional.isEmpty()) return ResponseEntity.notFound().build();

        user.setUserId(id);
        userService.save(user);

        return ResponseEntity.noContent().build();
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    //ReadAll
    @GetMapping
    public List<User> getAllUser(){
        return userService.getAll();
    }

    //ReadById

    @GetMapping("/find/{id}")
    public User findByIdUser(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        return user.get();
    }




}
