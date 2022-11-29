package com.cootlihelp.movieproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.build.Plugin.Engine.ErrorHandler;

@RestController
@RequestMapping("")
/**
 * TestController
 **/
public class UsersLandingController {

    @GetMapping("/user")

    public ResponseEntity<String> get() {
        return AppErrorController.class;
    }
}