package com.encora.movieapi.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.encora.movieapi.entities.Movies;
import com.encora.movieapi.entities.Users;


public interface MoviesRepository extends JpaRepository<Movies, Long> {
    @Transactional
    @Modifying
    @Query(value = "update movies set user_id =:users", nativeQuery=true)
    void addUser(@Param("users")Users user);

    @Query(value = "select * from movies where movies.movie_name =:name", nativeQuery = true)
    Optional<Movies> getMovie(@Param("name")String name);
}