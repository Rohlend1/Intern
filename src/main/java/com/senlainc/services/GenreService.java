package com.senlainc.services;

import com.senlainc.dto.genres.GenreDto;

import java.util.List;

public interface GenreService {

    List<GenreDto> findAll();

    GenreDto findById(int id);

    void saveOrUpdate(GenreDto genre);

    void delete(GenreDto genre);

    void delete(int id);

    List<GenreDto> findGenreLike(char ch);

    GenreDto findMostPopularGenre();

    List<GenreDto> findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(long amount, int duration);
}
