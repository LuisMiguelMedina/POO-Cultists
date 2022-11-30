package servicesInterfaces;

import java.util.List;

public interface MoviesServiceInterface<E>{
    //Pincipales de momento
    public List<E> finALl() throws Exception;
    public E findById(Integer id) throws Exception;
    public E findByName(String name) throws Exception;
    public List<E> findALlRating() throws Exception;


}
