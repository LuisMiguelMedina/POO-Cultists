package com.encora.movieapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.movieapi.Entities.Ratings;

@Repository
public interface RaitingsRepository extends JpaRepository<Ratings, Integer> {
}