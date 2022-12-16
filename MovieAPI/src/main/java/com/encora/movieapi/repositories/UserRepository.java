package com.encora.movieapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.encora.movieapi.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query(value = "select * from users where users.username =:username", nativeQuery = true)
    Users getUser(@Param("username")String username);
}