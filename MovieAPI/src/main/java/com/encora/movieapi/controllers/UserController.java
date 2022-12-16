package com.encora.movieapi.controllers;

import com.encora.movieapi.entities.Users;
import com.encora.movieapi.services.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users createUser(@RequestBody Users user){
        return userService.createUser(user);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable("id") Long id, @RequestBody Users user){
        Optional<Users> userOptional = userService.findById(id);
        if(userOptional.isEmpty()) return ResponseEntity.notFound().build();
        user.setUserId(id);
        userService.updateUser(user);

        return ResponseEntity.noContent().build();
    }

    //Delete
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    //ReadAll
    @GetMapping
    public List<Users> getAllUser(){
        return userService.getAll();
    }

    //ReadById

    @GetMapping("/{id}")
    public Users findByIdUser(@PathVariable Long id){
        Optional<Users> user = userService.findById(id);
        return user.get();
    }




}
