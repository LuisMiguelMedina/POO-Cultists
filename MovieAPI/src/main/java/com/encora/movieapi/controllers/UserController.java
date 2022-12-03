package com.encora.movieapi.controllers;

import com.encora.movieapi.Entities.User;
import com.encora.movieapi.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Create
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User createuser(@RequestBody User user){
        return userRepository.save(user);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) return ResponseEntity.notFound().build();

        user.setUserId(id);
        userRepository.save(user);

        return ResponseEntity.noContent().build();
    }

    //Delete
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }

    //ReadAll
    @GetMapping("/allusers")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    //ReadById

    @GetMapping("/{id}")
    public User findByIdUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }




}
