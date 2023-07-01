package com.senlainc.services;

import com.senlainc.models.FilmCompany;
import com.senlainc.models.Movie;
import com.senlainc.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Movie> findDateOfReleaseBetween(int year1, int year2){
        return movieRepository.findDateOfReleaseBetween(year1, year2);
    }

    public List<Movie> findFilmCompanyEqualsAndBoxOfficeGreaterThan(FilmCompany filmCompany, double millions){
        return movieRepository.findFilmCompanyEqualsAndBoxOfficeGreaterThan(filmCompany, millions);
    }

    public List<Movie> findActorsLowerThan(long amount){
        return movieRepository.findActorsLessThan(amount);
    }

    public List<Movie> findAllPagination(int page, int moviesPerPage){
        return movieRepository.findAllPagination(page,moviesPerPage);
    }
}
