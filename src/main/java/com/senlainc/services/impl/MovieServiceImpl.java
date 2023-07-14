package com.senlainc.services.impl;

import com.senlainc.dto.filmcompanies.FilmCompanyDto;
import com.senlainc.dto.movies.MovieDto;
import com.senlainc.models.FilmCompany;
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

    public List<MovieDto> findAll(){
        return converter.convertListToMovieDTO(movieRepository.findAll());
    }

    public MovieDto findById(int id){
        return converter.convertToMovieDTO(movieRepository.findById(id));
    }

    public void saveOrUpdate(MovieDto movieDTO){
        movieRepository.saveOrUpdate(converter.convertToMovie(movieDTO));
    }

    public void delete(MovieDto movieDTO){
        movieRepository.delete(converter.convertToMovie(movieDTO));
    }

    public void delete(int id) {
        movieRepository.delete(id);
    }

    public List<MovieDto> findByDateOfReleaseBetween(int year1, int year2){
        return converter.convertListToMovieDTO(movieRepository.findByDateOfReleaseBetween(year1, year2));
    }

    public List<MovieDto> findByFilmCompanyEqualsAndBoxOfficeGreaterThan(FilmCompanyDto filmCompanyDTO, double millions){
        FilmCompany filmCompany = converter.convertToFilmCompany(filmCompanyDTO);
        return converter.convertListToMovieDTO(movieRepository.findByFilmCompanyEqualsAndBoxOfficeGreaterThan(filmCompany, millions*1_000_000));
    }

    public List<MovieDto> findByActorsLessThan(long amount){
        return converter.convertListToMovieDTO(movieRepository.findByActorsLessThan(amount));
    }

    public List<MovieDto> findWithPagination(int page, int moviesPerPage){
        return converter.convertListToMovieDTO(movieRepository.findWithPagination(page, moviesPerPage));
    }
}
