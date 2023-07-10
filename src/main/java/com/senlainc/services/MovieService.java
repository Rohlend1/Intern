package com.senlainc.services;

import com.senlainc.models.FilmCompany;
import com.senlainc.models.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    Movie findById(int id);

    void saveOrUpdate(Movie movie);

    void delete(Movie movie);

    List<Movie> findByDateOfReleaseBetween(int year1, int year2);

    List<Movie> findByFilmCompanyEqualsAndBoxOfficeGreaterThan(FilmCompany filmCompany, double millions);

    List<Movie> findByActorsLessThan(long amount);

    List<Movie> findAllPagination(int page, int moviesPerPage);
}
