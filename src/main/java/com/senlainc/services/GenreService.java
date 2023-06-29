package com.senlainc.services;

import com.senlainc.models.Genre;
import com.senlainc.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAll(){
        return genreRepository.findAll();
    }

    public Genre findById(int id){
        return genreRepository.findById(id);
    }

    public void save(Genre genre){
        genreRepository.save(genre);
    }

    public void delete(Genre genre){
        genreRepository.delete(genre);
    }

    public void update(int id, Genre genre){
        genreRepository.delete(genreRepository.findById(id));
        genre.setId(id);
        genreRepository.save(genre);
    }

    public List<Genre> findGenreLike(char ch){
        return genreRepository.findGenreLike(ch);
    }

    public Genre findMostPopularGenre(){
        return genreRepository.findMostPopularGenre();
    }

    public List<Genre> findMoviesGreaterThanAndMoviesDurationGreaterThan(int amount, int duration){
        return genreRepository.findMoviesGreaterThanAndMoviesDurationGreaterThan(amount,duration);
    }
}
