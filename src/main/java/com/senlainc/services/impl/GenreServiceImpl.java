package com.senlainc.services.impl;

import com.senlainc.dto.genres.GenreDTO;
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

    public List<GenreDTO> findAll(){
        return converter.convertListToGenreDTO(genreRepository.findAll());
    }

    public GenreDTO findById(int id){
        return converter.convertToGenreDTO(genreRepository.findById(id));
    }

    public void saveOrUpdate(GenreDTO genreDTO){
        genreRepository.saveOrUpdate(converter.convertToGenre(genreDTO));
    }

    public void delete(GenreDTO genreDTO){
        genreRepository.delete(converter.convertToGenre(genreDTO));
    }

    public void delete(int id) {
        genreRepository.delete(id);
    }

    public List<GenreDTO> findGenreLike(char ch){
        return converter.convertListToGenreDTO(genreRepository.findGenreLike(ch+"%"));
    }

    public GenreDTO findMostPopularGenre(){
        return converter.convertToGenreDTO(genreRepository.findMostPopularGenre());
    }

    public List<GenreDTO> findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(long amount, int duration){
        return converter.convertListToGenreDTO(genreRepository.findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(amount,duration));
    }
}
