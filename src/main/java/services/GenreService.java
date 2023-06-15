package services;

import models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.GenreRepository;

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
        delete(genreRepository.findById(id));
        genre.setId(id);
        genreRepository.save(genre);
    }
}
