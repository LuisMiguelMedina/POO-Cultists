package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movies implements Serializable {

    @Id
    @Column(
            name = "movie_id",
            unique = true
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Integer movieId;

    @Column(name = "relase_year")
    private Integer relaseYear;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "update_at")
    private Date updateAt;

    //Una pelicula tiene muchos ratings
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Raitings> raitingsList;




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