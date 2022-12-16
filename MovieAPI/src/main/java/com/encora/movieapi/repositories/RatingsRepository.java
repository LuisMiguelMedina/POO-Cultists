
package com.encora.movieapi.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.encora.movieapi.entities.Movies;
import com.encora.movieapi.entities.Ratings;
import com.encora.movieapi.entities.Users;

public interface RatingsRepository extends JpaRepository<Ratings, Long> {
    @Transactional
    @Modifying
    @Query(value = "update ratings set user_id =:users where rating_id =:id", nativeQuery=true)
    void addUser(@Param("users")Users user, @Param("id")Long id);
    
    @Transactional
    @Modifying
    @Query(value = "update ratings set movies_id =:movie where rating_id =:id", nativeQuery=true)
    void addMovie(@Param("movie")Movies movie, @Param("id")Long id);
}