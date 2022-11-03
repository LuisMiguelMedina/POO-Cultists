package com.cootlihelp.movieproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/message")
/**
 * TestController
 */
public class TestController {

    @GetMapping("/hello")

    public ResponseEntity<String> get() {
        return ResponseEntity.ok("It works!");
    }
}

