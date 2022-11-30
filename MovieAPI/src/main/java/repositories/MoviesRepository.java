package repositories;

import Entities.Movies;
import Entities.Raitings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {

    @Query(
            value = "SELECT * raitings.raiting.id, raitings.time, raitings.sumary, raitings.review",
            nativeQuery = true
    )
    List<Raitings> searchAllRaitings();
}