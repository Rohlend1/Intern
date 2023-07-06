package com.senlainc.services;

import com.senlainc.config.SpringConfig;
import com.senlainc.models.Genre;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
@Transactional
public class TestGenreService {

    @Autowired
    private GenreService genreService;

    @Test
    public void testFindGenreLike(){
        List<Genre> expectedGenres = new ArrayList<>();
        List<Genre> actualGenres = genreService.findGenreLike('A');

        expectedGenres.add(genreService.findById(1));

        actualGenres.sort(Comparator.comparingInt(Genre::getId));
        expectedGenres.sort(Comparator.comparingInt(Genre::getId));

        assertEquals(expectedGenres, actualGenres);
    }

    @Test
    public void testFindMostPopularGenre(){
        assertEquals(genreService.findById(2), genreService.findMostPopularGenre());
    }

    @Test
    public void testFindAll(){
        assertEquals(4,genreService.findAll().size());
    }

    @Test
    public void testFindByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(){
        List<Genre> expectedGenres = new ArrayList<>();
        List<Genre> actualGenres = genreService.findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(2,100);

        expectedGenres.add(genreService.findById(2));

        actualGenres.sort(Comparator.comparingInt(Genre::getId));
        expectedGenres.sort(Comparator.comparingInt(Genre::getId));

        assertEquals(expectedGenres, actualGenres);
    }
}
