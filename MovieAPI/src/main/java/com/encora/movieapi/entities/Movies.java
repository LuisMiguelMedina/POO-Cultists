package com.encora.movieapi.Entities;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "movies")
public class Movies implements Serializable {

    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    private Long movieId;

    @Column(name = "movie_name")
    private String movie_name;

    @Column(name = "release_year")
    private int releaseYear;


    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    //Relationships

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ratings> ratingsList;

    @ManyToOne(fetch = FetchType.LAZY, cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, targetEntity = User.class)
    @JoinColumn(name = "users")
    private User users;




    public Movies() {

    }

    //Createdad lo quite porque al parecer con las anotaciones hará ese trabajo
    public Movies(Long movieId, String name, int releaseYear) {
        this.movieId = movieId;
        this.movie_name = name;
        this.releaseYear = releaseYear;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
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

    public User getUser() {
        return users;
    }

    public void setUser(User user) {
        this.users = user;
    }
}