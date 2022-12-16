package com.encora.movieapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ratings")
public class Ratings implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long  ratingId;

    @Column(
            name = "summary",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String summary;

    @Column(
            name = "review",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String review;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    //Relationships

    @ManyToOne(fetch = FetchType.LAZY, cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, targetEntity = Movies.class)
    @JoinColumn(name = "movies_id")
    private Movies movie;

    @ManyToOne(fetch = FetchType.LAZY, cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, targetEntity = Users.class)
    @JoinColumn(name = "user_id")
    private Users user;

    //Constructors
    public Ratings() {}

    public Ratings(Long raintingId, String summary, String review) {
        this.ratingId = raintingId;
        this.summary = summary;
        this.review = review;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRaintingId(Long raintingId) {
        this.ratingId = raintingId;
    }


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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
