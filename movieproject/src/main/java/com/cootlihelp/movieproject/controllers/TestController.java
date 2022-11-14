package com.cootlihelp.movieproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
/**
 * TestController
 */
public class TestController {

    @GetMapping("/")

    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Welcome to the jungle B*TCH!");
    }
}

