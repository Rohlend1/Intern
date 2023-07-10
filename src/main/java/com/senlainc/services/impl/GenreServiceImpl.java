package com.senlainc.services.impl;

import com.senlainc.models.Genre;
import com.senlainc.repositories.GenreRepository;
import com.senlainc.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAll(){
        return genreRepository.findAll();
    }

    public Genre findById(int id){
        return genreRepository.findById(id);
    }

    public void saveOrUpdate(Genre genre){
        genreRepository.saveOrUpdate(genre);
    }

    public void delete(Genre genre){
        genreRepository.delete(genre);
    }

    public List<Genre> findGenreLike(char ch){
        return genreRepository.findGenreLike(ch+"%");
    }

    public Genre findMostPopularGenre(){
        return genreRepository.findMostPopularGenre();
    }

    public List<Genre> findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(long amount, int duration){
        return genreRepository.findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(amount,duration);
    }
}
