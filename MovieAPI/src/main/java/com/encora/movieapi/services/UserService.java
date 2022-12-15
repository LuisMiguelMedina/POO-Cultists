package com.encora.movieapi.services;

import com.encora.movieapi.entities.Users;
import com.encora.movieapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<Users> findById(Long id){
        return userRepository.findById(id);
    }

    public List<Users> getAll(){
        return userRepository.findAll();
    }

    @Transactional
    public Users save(Users user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public Users getUser(String username){
        return userRepository.getUser(username);
    }

}
