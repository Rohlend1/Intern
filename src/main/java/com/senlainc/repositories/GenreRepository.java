package com.senlainc.repositories;

import com.senlainc.models.Genre;

import java.util.List;

public interface GenreRepository {

    List<Genre> findAll();

    void saveOrUpdate(Genre genre);

    Genre findById(int id);

    void delete(Genre genre);

    List<Genre> findGenreLike(String ch);
    List<Genre> findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(long amount, int duration);

    Genre findMostPopularGenre();
}
