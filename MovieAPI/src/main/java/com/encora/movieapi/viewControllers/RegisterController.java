package com.encora.movieapi.viewControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.encora.movieapi.entities.Users;
import com.encora.movieapi.services.UserService;


@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        Users user = new Users();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String createNewUser(@ModelAttribute Users user) {
        userService.createUser(user);
        return "redirect:/";
    }
    
}
