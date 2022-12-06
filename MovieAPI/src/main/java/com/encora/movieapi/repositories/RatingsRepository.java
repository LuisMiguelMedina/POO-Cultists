package com.encora.movieapi.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.encora.movieapi.Entities.Movies;
import com.encora.movieapi.Entities.Ratings;
import com.encora.movieapi.Entities.User;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, Long> {
    @Transactional
    @Modifying
    @Query(value = "update ratings set user_id =:users where rating_id =:id", nativeQuery=true)
    void addUser(@Param("users")User user, @Param("id")Long id);
    
    @Transactional
    @Modifying
    @Query(value = "update ratings set movies_id =:movie where rating_id =:id", nativeQuery=true)
    void addMovie(@Param("movie")Movies movie, @Param("id")Long id);
}