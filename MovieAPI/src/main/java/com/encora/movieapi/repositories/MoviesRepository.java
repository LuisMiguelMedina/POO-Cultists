package com.encora.movieapi.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.encora.movieapi.Entities.Movies;
import com.encora.movieapi.Entities.User;


@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {
    @Transactional
    @Modifying
    @Query(value = "update movies set users =:users", nativeQuery=true)
    void addUser(@Param("users")User user);
}