package com.encora.movieapi.services;

import com.encora.movieapi.Entities.User;
import com.encora.movieapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class UserService {
    @Autowired
    UserRepository userRepository;

    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Transactional
    public  User save(User user){
        return userRepository.save(user);
    }
}
