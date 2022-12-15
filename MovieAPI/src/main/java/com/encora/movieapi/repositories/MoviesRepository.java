package com.encora.movieapi.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.encora.movieapi.entities.Movies;
import com.encora.movieapi.entities.User;


@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {
    @Transactional
    @Modifying
    @Query(value = "update movies set users =:users", nativeQuery=true)
    void addUser(@Param("users")User user);

    @Query(value = "select * from movies where movies.movie_name =:name", nativeQuery = true)
    Movies getMovie(@Param("name")String name);
}