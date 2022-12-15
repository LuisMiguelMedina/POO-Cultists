package com.encora.movieapi.Entities;

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

    @Column(name = "time" )
    private LocalDateTime time;

    @Column(
            name = "summary",
            columnDefinition = "TEXT"
    )
    private String summary;

    @Column(
            name = "review",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String review;

    //Relationships

    @ManyToOne(fetch = FetchType.LAZY, cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, targetEntity = Movies.class)
    @JoinColumn(name = "movies_id")
    private Movies movie;

    @ManyToOne(fetch = FetchType.LAZY, cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    //Constructors
    public Ratings() {}

    public Ratings(Long raintingId, LocalDateTime time, String summary, String review) {
        this.ratingId = raintingId;
        this.time = time;
        this.summary = summary;
        this.review = review;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRaintingId(Long raintingId) {
        this.ratingId = raintingId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
