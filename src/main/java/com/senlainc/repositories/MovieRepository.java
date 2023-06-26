package com.senlainc.repositories;

import com.senlainc.errors.ModelNotFoundException;
import com.senlainc.models.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    private final List<Movie> movies = new ArrayList<>();

    public List<Movie> findAll() {
        return movies;
    }

    public void save(Movie movie) {
        movies.add(movie);
    }

    public Movie findOne(Movie movie){
        return movies.stream().filter(a->a.equals(movie)).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public Movie findById(int id){
        return movies.stream().filter(a->a.getId()==id).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public void delete(Movie movie){
        movies.remove(movie);
    }
}
