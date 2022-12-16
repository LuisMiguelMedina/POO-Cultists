package com.encora.movieapi.services;

import com.encora.movieapi.entities.Users;
import com.encora.movieapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
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
    public Users createUser(Users user){
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdateAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Transactional
    public Users updateUser(Users user){
        user.setUpdateAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public Users getUser(String username){
        return userRepository.getUser(username);
    }

}
