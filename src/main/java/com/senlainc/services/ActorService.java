package com.senlainc.services;

import com.senlainc.dto.actors.ActorDto;
import com.senlainc.util.Gender;

import java.util.List;

public interface ActorService {

    List<ActorDto> findAll();

    ActorDto findById(int id);

    void saveOrUpdate(ActorDto actor);

    void delete(ActorDto actor);

    void delete(int id);

    List<ActorDto> findByCountryEqualsAndLastNameEndsWithAndAgeLessThan(String country, String endsWith, int years);

    List<ActorDto> findByGenderAndFromCountry(Gender gender, String country);

    List<ActorDto> findByMoviesMoreThanAndBornInTwentiethCentury(long amount);
}
