package com.senlainc.repositories;

import com.senlainc.models.Actor;
import com.senlainc.util.Gender;

import java.util.List;

public interface ActorRepository {

    List<Actor> findAll();

    void saveOrUpdate(Actor actor);

    Actor findById(int id);

    void delete(Actor actor);

    void delete(int id);

    List<Actor> findByCountryEqualsAndLastNameEndsWithAndAgeLessThan(String country, String endsWith, int years);

    List<Actor> findByGenderAndFromCountry(Gender gender, String country);

    List<Actor> findByMoviesMoreThanAndBornInTwentiethCentury(long amount);
}
