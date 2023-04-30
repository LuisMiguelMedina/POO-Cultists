package com.encora.mx.restapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "MOVIE")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 30, nullable = false)
    private String name;

    @Column(name = "DATEPAGE")
    private LocalDate datePage;

    @Column(name = "DATEMOVIE", nullable = false)
    private LocalDate dateMovie;


    @ManyToMany
    private List<Director> directors;

    public Movie(String name, LocalDate dateMovie) {
        this.name = name;
        this.dateMovie = dateMovie;
    }
}
