package repositories;

import models.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {

    private List<Movie> movies;

    public List<Movie> findAll() {
        return movies;
    }

    public void save(Movie movie) {
        movies.add(movie);
    }

    public Movie findOne(Movie movie){
        return movies.stream().filter(a->a.equals(movie)).findAny().orElse(null);
    }

    public Movie findById(int id){
        return movies.stream().filter(a->a.getId()==id).findAny().orElse(null);
    }

    public void delete(Movie movie){
        movies.remove(movie);
    }
}
