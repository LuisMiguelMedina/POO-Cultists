package services;

import Entities.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.MoviesRepository;
import servicesInterfaces.MoviesServiceInterface;

import java.util.List;

public class MoviesService implements MoviesServiceInterface<Movies> {
    @Autowired
    MoviesRepository moviesRepository;

    //Las excepciones son manejadas por el controlador
    @Override
    public List<Movies> finALl() throws Exception {
        try {
            List<Movies> movies = moviesRepository.findAll();
            return movies;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Movies findById(Integer id) {
        return null;
    }

    @Override
    public Movies findByName(String name) {
        return null;
    }

    @Override
    public List<Movies> findALlRating() {
        return null;
    }
}
