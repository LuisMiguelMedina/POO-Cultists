package com.encora.movieapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.encora.movieapi.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from users where users.username =:username", nativeQuery = true)
    User getUser(@Param("username")String username);
}