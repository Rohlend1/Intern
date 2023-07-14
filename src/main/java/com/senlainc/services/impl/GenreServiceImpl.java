package com.senlainc.services.impl;

import com.senlainc.dto.genres.GenreDto;
import com.senlainc.repositories.GenreRepository;
import com.senlainc.services.GenreService;
import com.senlainc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    private final Converter converter;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository, Converter converter) {
        this.genreRepository = genreRepository;
        this.converter = converter;
    }

    public List<GenreDto> findAll(){
        return converter.convertListToGenreDTO(genreRepository.findAll());
    }

    public GenreDto findById(int id){
        return converter.convertToGenreDTO(genreRepository.findById(id));
    }

    public void saveOrUpdate(GenreDto genreDTO){
        genreRepository.saveOrUpdate(converter.convertToGenre(genreDTO));
    }

    public void delete(GenreDto genreDTO){
        genreRepository.delete(converter.convertToGenre(genreDTO));
    }

    public void delete(int id) {
        genreRepository.delete(id);
    }

    public List<GenreDto> findGenreLike(char ch){
        return converter.convertListToGenreDTO(genreRepository.findGenreLike(ch+"%"));
    }

    public GenreDto findMostPopularGenre(){
        return converter.convertToGenreDTO(genreRepository.findMostPopularGenre());
    }

    public List<GenreDto> findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(long amount, int duration){
        return converter.convertListToGenreDTO(genreRepository.findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(amount,duration));
    }
}
