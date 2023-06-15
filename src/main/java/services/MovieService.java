package services;

import models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public Movie findById(int id){
        return movieRepository.findById(id);
    }

    public void save(Movie movie){
        movieRepository.save(movie);
    }

    public void delete(Movie movie){
        movieRepository.delete(movie);
    }

    public void update(int id, Movie movie){
        movieRepository.delete(movieRepository.findById(id));
        movie.setId(id);
        movieRepository.save(movie);
    }
}
