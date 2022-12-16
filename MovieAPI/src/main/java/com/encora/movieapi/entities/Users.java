package com.encora.movieapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @Column(name = "users_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(
            name = "username",
            unique = true,
            nullable = false,
            length = 10
    )
    private String username;
    @Column(
            name = "email",
            unique = true,
            nullable = false,
            length = 30
    )
    private String userEmail;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;


    //Relationships
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ratings> ratingsList;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Movies> moviesList;


    public Users (){ }
    public Users(Long userId, String username, String user_email) {
        this.userId = userId;
        this.username = username;
        this.userEmail = user_email;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return userEmail;
    }

    public void setEmail(String email) {
        this.userEmail = email;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Ratings> getRatingsList() {
        return ratingsList;
    }

    public void setRatingsList(List<Ratings> ratingsList) {
        this.ratingsList = ratingsList;
    }

    public List<Movies> getMoviesList() {
        return this.moviesList;
    }

    public void setMovie(Movies movie) {
        this.moviesList.clear();
        if(movie != null){
            this.moviesList.add(movie);
        }
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
