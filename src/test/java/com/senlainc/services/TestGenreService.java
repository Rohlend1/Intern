package com.senlainc.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.senlainc.config.TestConfig;
import com.senlainc.models.Genre;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:dataset.xml")
@DbUnitConfiguration(databaseConnection = "dataSource")
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
