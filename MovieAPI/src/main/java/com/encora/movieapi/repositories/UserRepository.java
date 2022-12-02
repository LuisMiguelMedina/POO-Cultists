package com.encora.movieapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.movieapi.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}