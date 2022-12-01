package com.encora.movieapi.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movies implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int movieId;

    @Column(name = "movie_name")
    private String movie_name;

    @Column(name = "relase_year")
    private int relaseYear;

    @Column(name = "created_at")
    private Time createdAt;

    @Column(name = "update_at")
    private Time updateAt;

    //Una pelicula tiene muchos ratings
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Raitings> raitingsList;




    public Movies() {

    }

    public Movies(int movieId, String name, int relaseYear, Time createdAt, Time updateAt) {
        this.movieId = movieId;
        this.movie_name = name;
        this.relaseYear = relaseYear;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return movie_name;
    }

    public void setName(String name) {
        this.movie_name = name;
    }

    public int getRelaseYear() {
        return relaseYear;
    }

    public void setRelaseYear(int relaseYear) {
        this.relaseYear = relaseYear;
    }

    public Time getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Time createdAt) {
        this.createdAt = createdAt;
    }

    public Time getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Time updateAt) {
        this.updateAt = updateAt;
    }
}