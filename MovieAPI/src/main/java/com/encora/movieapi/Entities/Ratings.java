package com.encora.movieapi.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "ratings")
public class Ratings implements Serializable {
    @Id
    @Column(
            name = "raiting_id",
            nullable = false,
            unique = true
    )
    private Long  raintingId;

    @Column(
            name = "time",
            nullable = false
    )
    private Time time;

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

    //Relationships

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movies_id")
    private Movies movie;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    //Constructors
    public Ratings() {}

    public Ratings(Long raintingId, Time time, String summary, String review) {
        this.raintingId = raintingId;
        this.time = time;
        this.summary = summary;
        this.review = review;
    }

    public Long getRaintingId() {
        return raintingId;
    }

    public void setRaintingId(Long raintingId) {
        this.raintingId = raintingId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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
