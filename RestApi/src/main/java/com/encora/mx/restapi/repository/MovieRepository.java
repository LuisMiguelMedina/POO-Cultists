package com.encora.mx.restapi.repository;


import com.encora.mx.restapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT * FROM movie WHERE name = :name AND datemovie = :dateMovie", nativeQuery = true)
    Movie findByDateMovieAndName(@Param("dateMovie") LocalDate dateMovie, @Param("name") String name);

    List<Movie> findAllByName(String name);
}
