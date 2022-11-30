package com.encora.movieapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.movieapi.Entities.Movies;


@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {

}