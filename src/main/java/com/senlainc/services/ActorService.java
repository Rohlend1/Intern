package com.senlainc.services;

import com.senlainc.models.Actor;
import com.senlainc.util.Gender;

import java.util.List;

public interface ActorService {

    List<Actor> findAll();

    Actor findById(int id);

    void saveOrUpdate(Actor actor);

    void delete(Actor actor);

    List<Actor> findByCountryEqualsAndLastNameEndsWithAndLessThan(String country, String endsWith, int years);

    List<Actor> findByGenderAndFromCountry(Gender gender, String country);

    List<Actor> findByMoviesMoreThanAndBornInTwentiethCentury(long amount);
}
