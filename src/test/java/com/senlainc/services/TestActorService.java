package com.senlainc.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.senlainc.config.TestConfig;
import com.senlainc.models.Actor;
import com.senlainc.util.Gender;
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
public class TestActorService {

    @Autowired
    private ActorService actorService;

    @Test
    public void testFindByCountryEqualsAndLastNameEndsWithAndLessThan(){
        List<Actor> expectedActors = new ArrayList<>();

        expectedActors.add(actorService.findById(4));
        expectedActors.add(actorService.findById(5));

        assertEquals(expectedActors, actorService.findByCountryEqualsAndLastNameEndsWithAndAgeLessThan("Canada","s",50));
    }

    @Test
    public void testFindByGenderAndFromCountry(){
        List<Actor> expectedActors = new ArrayList<>();

        expectedActors.add(actorService.findById(1));
        expectedActors.add(actorService.findById(2));

        assertEquals(expectedActors, actorService.findByGenderAndFromCountry(Gender.MALE, "USA"));
    }

    @Test
    public void testFindByMoviesMoreThanAndBornInTwentiethCentury(){
        List<Actor> expectedActors = new ArrayList<>();

        expectedActors.add(actorService.findById(1));
        expectedActors.add(actorService.findById(2));

        assertEquals(expectedActors, actorService.findByMoviesMoreThanAndBornInTwentiethCentury(2));
    }
}
