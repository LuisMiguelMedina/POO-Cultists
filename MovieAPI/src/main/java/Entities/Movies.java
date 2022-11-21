package Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "movies")
public class Movies {

    @Id
    @Column(name = "movie_id")
    @SequenceGenerator(
            name = "movies_sequence",
            sequenceName = "movies_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movies_sequence"
    )
    private int movieId;

    @Column(name = "relase_year")
    private int relaseYear;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "update_at")
    private Date updateAt;

    public Movies() {

    }

    public Movies(int movieId, int relaseYear, Date createdAt, Date updateAt) {
        this.movieId = movieId;
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

    public int getRelaseYear() {
        return relaseYear;
    }

    public void setRelaseYear(int relaseYear) {
        this.relaseYear = relaseYear;
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