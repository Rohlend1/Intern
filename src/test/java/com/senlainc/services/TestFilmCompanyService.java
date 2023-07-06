package com.senlainc.services;

import com.senlainc.config.SpringConfig;
import com.senlainc.models.FilmCompany;
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
public class TestFilmCompanyService {

    @Autowired
    private FilmCompanyService filmCompanyService;

    @Test
    public void testFindLeastPopularFilmCompany(){
       assertEquals(filmCompanyService.findById(3), filmCompanyService.findLeastPopularFilmCompany());
    }

    @Test
    public void testFindAllSortByName(){
        List<FilmCompany> expectedFilmCompanies = filmCompanyService.findAll();

        expectedFilmCompanies.sort(Comparator.comparing(FilmCompany::getName));

        assertEquals(expectedFilmCompanies, filmCompanyService.findAllSortByName());
    }

    @Test
    public void testFindByDateOfFoundationLessThan(){
        List<FilmCompany> expectedFilmCompanies = new ArrayList<>();

        List<FilmCompany> allCompanies = filmCompanyService.findAll();

        expectedFilmCompanies.add(filmCompanyService.findById(1));
        expectedFilmCompanies.add(filmCompanyService.findById(2));

        assertEquals(expectedFilmCompanies, filmCompanyService.findByDateOfFoundationLessThan(1961));
    }

    @Test
    public void testFindByNameWithTwoWordsAndDateOfFoundationBetween(){
        List<FilmCompany> expectedFilmCompanies = new ArrayList<>();

        expectedFilmCompanies.add(filmCompanyService.findById(2));

        assertEquals(expectedFilmCompanies, filmCompanyService.findByNameWithTwoWordsAndDateOfFoundationBetween(1890,1960));
    }
}
