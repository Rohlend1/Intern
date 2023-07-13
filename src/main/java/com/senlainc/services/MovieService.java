package com.senlainc.services;

import com.senlainc.dto.filmcompanies.FilmCompanyDTO;
import com.senlainc.dto.movies.MovieDTO;
import com.senlainc.models.FilmCompany;
import com.senlainc.models.Movie;

import java.util.List;

public interface MovieService {

    List<MovieDTO> findAll();

    MovieDTO findById(int id);

    void saveOrUpdate(MovieDTO movie);

    void delete(MovieDTO movie);

    void delete(int id);

    List<MovieDTO> findByDateOfReleaseBetween(int year1, int year2);

    List<MovieDTO> findByFilmCompanyEqualsAndBoxOfficeGreaterThan(FilmCompanyDTO filmCompany, double millions);

    List<MovieDTO> findByActorsLessThan(long amount);

    List<MovieDTO> findAllPagination(int page, int moviesPerPage);
}
