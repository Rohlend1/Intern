package com.senlainc.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.senlainc.config.TestConfig;
import com.senlainc.models.FilmCompany;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:dataset.xml")
@DbUnitConfiguration(databaseConnection = "dataSource")
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
