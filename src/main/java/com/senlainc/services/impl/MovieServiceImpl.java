package com.senlainc.services.impl;

import com.senlainc.dto.filmcompanies.FilmCompanyDTO;
import com.senlainc.dto.movies.MovieDTO;
import com.senlainc.models.FilmCompany;
import com.senlainc.models.Movie;
import com.senlainc.repositories.MovieRepository;
import com.senlainc.services.MovieService;
import com.senlainc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final Converter converter;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, Converter converter) {
        this.movieRepository = movieRepository;
        this.converter = converter;
    }

    public List<MovieDTO> findAll(){
        return converter.convertListToMovieDTO(movieRepository.findAll());
    }

    public MovieDTO findById(int id){
        return converter.convertToMovieDTO(movieRepository.findById(id));
    }

    public void saveOrUpdate(MovieDTO movieDTO){
        movieRepository.saveOrUpdate(converter.convertToMovie(movieDTO));
    }

    public void delete(MovieDTO movieDTO){
        movieRepository.delete(converter.convertToMovie(movieDTO));
    }

    public void delete(int id) {
        movieRepository.delete(id);
    }

    public List<MovieDTO> findByDateOfReleaseBetween(int year1, int year2){
        return converter.convertListToMovieDTO(movieRepository.findByDateOfReleaseBetween(year1, year2));
    }

    public List<MovieDTO> findByFilmCompanyEqualsAndBoxOfficeGreaterThan(FilmCompanyDTO filmCompanyDTO, double millions){
        FilmCompany filmCompany = converter.convertToFilmCompany(filmCompanyDTO);
        return converter.convertListToMovieDTO(movieRepository.findByFilmCompanyEqualsAndBoxOfficeGreaterThan(filmCompany, millions*1_000_000));
    }

    public List<MovieDTO> findByActorsLessThan(long amount){
        return converter.convertListToMovieDTO(movieRepository.findByActorsLessThan(amount));
    }

    public List<MovieDTO> findAllPagination(int page, int moviesPerPage){
        return converter.convertListToMovieDTO(movieRepository.findAllPagination(page, moviesPerPage));
    }
}
