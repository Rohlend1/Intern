package com.senlainc.services;

import com.senlainc.dto.filmcompanies.FilmCompanyDto;
import com.senlainc.dto.movies.MovieDto;

import java.util.List;

public interface MovieService {

    List<MovieDto> findAll();

    MovieDto findById(int id);

    void saveOrUpdate(MovieDto movie);

    void delete(MovieDto movie);

    void delete(int id);

    List<MovieDto> findByDateOfReleaseBetween(int year1, int year2);

    List<MovieDto> findByFilmCompanyEqualsAndBoxOfficeGreaterThan(FilmCompanyDto filmCompany, double millions);

    List<MovieDto> findByActorsLessThan(long amount);

    List<MovieDto> findWithPagination(int page, int moviesPerPage);
}
