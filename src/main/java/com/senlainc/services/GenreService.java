package com.senlainc.services;

import com.senlainc.models.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> findAll();

    Genre findById(int id);

    void saveOrUpdate(Genre genre);

    void delete(Genre genre);

    List<Genre> findGenreLike(char ch);

    Genre findMostPopularGenre();

    List<Genre> findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(long amount, int duration);
}
