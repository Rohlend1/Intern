package com.senlainc.services;

import com.senlainc.dto.genres.GenreDTO;
import com.senlainc.models.Genre;

import java.util.List;

public interface GenreService {

    List<GenreDTO> findAll();

    GenreDTO findById(int id);

    void saveOrUpdate(GenreDTO genre);

    void delete(GenreDTO genre);

    void delete(int id);

    List<GenreDTO> findGenreLike(char ch);

    GenreDTO findMostPopularGenre();

    List<GenreDTO> findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(long amount, int duration);
}
