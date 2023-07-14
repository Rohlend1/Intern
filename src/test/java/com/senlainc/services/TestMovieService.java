package com.senlainc.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.senlainc.config.TestConfig;
import com.senlainc.models.Movie;
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
public class TestMovieService {

    @Autowired
    private MovieService movieService;
    @Autowired
    private FilmCompanyService filmCompanyService;

    @Test
    public void testFindAllPagination(){
        List<Movie> expectedMovies = new ArrayList<>();
        List<Movie> actualMovies = movieService.findWithPagination(1,2);

        expectedMovies.add(movieService.findById(1));
        expectedMovies.add(movieService.findById(2));

        actualMovies.sort(Comparator.comparingInt(Movie::getId));
        expectedMovies.sort(Comparator.comparingInt(Movie::getId));

        assertEquals(expectedMovies, actualMovies);
    }

    @Test
    public void testFindByActorsLessThan(){
        List<Movie> expectedMovies = new ArrayList<>();
        List<Movie> actualMovies = movieService.findByActorsLessThan(5);

        expectedMovies.add(movieService.findById(1));
        expectedMovies.add(movieService.findById(2));
        expectedMovies.add(movieService.findById(4));
        expectedMovies.add(movieService.findById(5));

        actualMovies.sort(Comparator.comparingInt(Movie::getId));
        expectedMovies.sort(Comparator.comparingInt(Movie::getId));

        assertEquals(expectedMovies, actualMovies);
    }

    @Test
    public void testFindByDateOfReleaseBetween(){
        List<Movie> expectedMovies = new ArrayList<>();
        List<Movie> actualMovies = movieService.findByDateOfReleaseBetween(1970,2010);

        expectedMovies.add(movieService.findById(1));
        expectedMovies.add(movieService.findById(2));

        actualMovies.sort(Comparator.comparingInt(Movie::getId));
        expectedMovies.sort(Comparator.comparingInt(Movie::getId));

        assertEquals(expectedMovies,actualMovies);
    }

    @Test
    public void testFindByFilmCompanyEqualsAndBoxOfficeGreaterThan(){

        List<Movie> actualMovies = movieService.
                findByFilmCompanyEqualsAndBoxOfficeGreaterThan(filmCompanyService.findById(3),50);
        List<Movie> expectedMovies = new ArrayList<>();

        expectedMovies.add(movieService.findById(3));

        actualMovies.sort(Comparator.comparingInt(Movie::getId));
        expectedMovies.sort(Comparator.comparingInt(Movie::getId));

        assertEquals(expectedMovies,actualMovies);
    }
}
