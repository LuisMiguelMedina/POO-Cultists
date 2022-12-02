package com.encora.movieapi.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movies implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int movieId;

    @Column(name = "movie_name")
    private String movie_name;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "update_at")
    private Date updateAt;

    //Relationships

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Ratings> ratingsList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;




    public Movies() {

    }

    public Movies(int movieId, String name, int releaseYear, Date createdAt, Date updateAt) {
        this.movieId = movieId;
        this.movie_name = name;
        this.releaseYear = releaseYear;
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

    public int getreleaseYear() {
        return releaseYear;
    }

    public void setreleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}