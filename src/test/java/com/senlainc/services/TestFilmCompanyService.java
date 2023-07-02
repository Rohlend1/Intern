package com.senlainc.services;

import com.senlainc.config.SpringConfig;
import com.senlainc.models.FilmCompany;
import com.senlainc.util.DatabasePreparer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestFilmCompanyService {
    private static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final FilmCompanyService filmCompanyService = context.getBean(FilmCompanyService.class);

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
    public void testFindLeastPopularFilmCompany(){
       assertEquals(filmCompanyService.findById(DatabasePreparer.filmCompanies.get(2).getId()),filmCompanyService.findLeastPopularFilmCompany());
    }

    @Test
    public void testFindAllSortByName(){
        List<FilmCompany> expectedFilmCompanies = new ArrayList<>();

        expectedFilmCompanies.add(filmCompanyService.findById(DatabasePreparer.filmCompanies.get(0).getId()));
        expectedFilmCompanies.add(filmCompanyService.findById(DatabasePreparer.filmCompanies.get(1).getId()));
        expectedFilmCompanies.add(filmCompanyService.findById(DatabasePreparer.filmCompanies.get(2).getId()));

        expectedFilmCompanies.sort(Comparator.comparing(FilmCompany::getName));

        assertEquals(expectedFilmCompanies,filmCompanyService.findAllSortByName());
    }

    @Test
    public void testFindByDateOfFoundationLessThan(){
        List<FilmCompany> expectedFilmCompanies = new ArrayList<>();

        expectedFilmCompanies.add(filmCompanyService.findById(DatabasePreparer.filmCompanies.get(0).getId()));
        expectedFilmCompanies.add(filmCompanyService.findById(DatabasePreparer.filmCompanies.get(1).getId()));

        assertEquals(expectedFilmCompanies,filmCompanyService.findByDateOfFoundationLessThan(1961));
    }

    @Test
    public void testFindByNameWithTwoWordsAndDateOfFoundationBetween(){
        List<FilmCompany> expectedFilmCompanies = new ArrayList<>();

        expectedFilmCompanies.add(filmCompanyService.findById(DatabasePreparer.filmCompanies.get(1).getId()));

        assertEquals(expectedFilmCompanies,filmCompanyService.findByNameWithTwoWordsAndDateOfFoundationBetween(1890,1960));
    }
}
