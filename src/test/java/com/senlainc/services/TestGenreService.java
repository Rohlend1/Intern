package com.senlainc.services;

import com.senlainc.config.SpringConfig;
import com.senlainc.models.Genre;
import com.senlainc.util.DatabasePreparer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestGenreService {

    private static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final GenreService genreService = context.getBean(GenreService.class);

    @BeforeAll
    public static void prepareDatabase(){
        DatabasePreparer.clearDatabase(context);
        DatabasePreparer.prepareDatabase(context);
    }

    @AfterAll
    public static void clearDatabase(){
        DatabasePreparer.clearDatabase(context);
    }

    @Test
    public void testFindGenreLike(){
        List<Genre> expectedGenres = new ArrayList<>();
        expectedGenres.add(genreService.findById(DatabasePreparer.genres.get(0).getId()));
        List<Genre> actualGenres = genreService.findGenreLike('A');
        actualGenres.sort((g1,g2)->g1.getId()-g2.getId());
        expectedGenres.sort((g1,g2)->g1.getId()-g2.getId());
        assertEquals(expectedGenres, actualGenres);
    }

    @Test
    public void testFindMostPopularGenre(){
        assertEquals(genreService.findById(DatabasePreparer.genres.get(1).getId()), genreService.findMostPopularGenre());
    }

    @Test
    public void testFindAll(){
        List<Genre> expectedGenres = new ArrayList<>();
        List<Genre> actualGenres = genreService.findAll();

        expectedGenres.add(genreService.findById(DatabasePreparer.genres.get(0).getId()));
        expectedGenres.add(genreService.findById(DatabasePreparer.genres.get(1).getId()));
        expectedGenres.add(genreService.findById(DatabasePreparer.genres.get(2).getId()));
        expectedGenres.add(genreService.findById(DatabasePreparer.genres.get(3).getId()));

        actualGenres.sort((g1,g2)->g1.getId()-g2.getId());
        expectedGenres.sort((g1,g2)->g1.getId()-g2.getId());

        assertEquals(expectedGenres, actualGenres);
    }

    @Test
    public void testFindByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(){
        List<Genre> expectedGenres = new ArrayList<>();
        expectedGenres.add(genreService.findById(DatabasePreparer.genres.get(1).getId()));
        List<Genre> actualGenres = genreService.findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(2,100);
        actualGenres.sort((g1,g2)->g1.getId()-g2.getId());
        expectedGenres.sort((g1,g2)->g1.getId()-g2.getId());
        assertEquals(expectedGenres, actualGenres);
    }
}
