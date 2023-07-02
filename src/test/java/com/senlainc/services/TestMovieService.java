package com.senlainc.services;

import com.senlainc.config.SpringConfig;
import com.senlainc.models.Movie;
import com.senlainc.util.DatabasePreparer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestMovieService {

    private static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final MovieService movieService = context.getBean(MovieService.class);

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
    public void testFindAllPagination(){
        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(movieService.findById(DatabasePreparer.movies.get(0).getId()));
        expectedMovies.add(movieService.findById(DatabasePreparer.movies.get(2).getId()));
        List<Movie> actualMovies = movieService.findAllPagination(1,2);
        actualMovies.sort((m1,m2)->m1.getId()-m2.getId());
        expectedMovies.sort((m1,m2)->m1.getId()-m2.getId());
        assertEquals(expectedMovies, actualMovies);
    }

    @Test
    public void testFindByActorsLessThan(){
        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(movieService.findById(DatabasePreparer.movies.get(0).getId()));
        expectedMovies.add(movieService.findById(DatabasePreparer.movies.get(1).getId()));
        expectedMovies.add(movieService.findById(DatabasePreparer.movies.get(3).getId()));
        expectedMovies.add(movieService.findById(DatabasePreparer.movies.get(4).getId()));
        List<Movie> actualMovies = movieService.findByActorsLessThan(5);
        actualMovies.sort((m1,m2)->m1.getId()-m2.getId());
        expectedMovies.sort((m1,m2)->m1.getId()-m2.getId());
        assertEquals(expectedMovies, actualMovies);
    }

    @Test
    public void testFindByDateOfReleaseBetween(){
        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(movieService.findById(DatabasePreparer.movies.get(0).getId()));
        expectedMovies.add(movieService.findById(DatabasePreparer.movies.get(1).getId()));
        List<Movie> actualMovies = movieService.findByDateOfReleaseBetween(1970,2010);
        actualMovies.sort((m1,m2)->m1.getId()-m2.getId());
        expectedMovies.sort((m1,m2)->m1.getId()-m2.getId());
        assertEquals(expectedMovies,actualMovies);
    }

    @Test
    public void testFindByFilmCompanyEqualsAndBoxOfficeGreaterThan(){
        FilmCompanyService filmCompanyService = context.getBean(FilmCompanyService.class);
        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(movieService.findById(DatabasePreparer.movies.get(2).getId()));
        List<Movie> actualMovies = movieService.
                findByFilmCompanyEqualsAndBoxOfficeGreaterThan(filmCompanyService.findById(DatabasePreparer.filmCompanies.get(2).getId()),50);
        actualMovies.sort((m1,m2)->m1.getId()-m2.getId());
        expectedMovies.sort((m1,m2)->m1.getId()-m2.getId());
        assertEquals(expectedMovies,actualMovies);
    }
}
