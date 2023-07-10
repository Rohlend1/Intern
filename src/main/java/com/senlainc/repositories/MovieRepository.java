package com.senlainc.repositories;

import com.senlainc.models.FilmCompany;
import com.senlainc.models.Movie;

import java.util.List;

public interface MovieRepository {

    List<Movie> findAll();

    void saveOrUpdate(Movie movie);

    Movie findById(int id);

    void delete(Movie movie);

    List<Movie> findByDateOfReleaseBetween(int year1, int year2);

    List<Movie> findByFilmCompanyEqualsAndBoxOfficeGreaterThan(FilmCompany filmCompany, double millions);

    List<Movie> findByActorsLessThan(long amount);

    List<Movie> findAllPagination(int page, int moviesPerPage);
}
