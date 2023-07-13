package com.senlainc.services;

import com.senlainc.dto.actors.ActorDTO;
import com.senlainc.util.Gender;

import java.util.List;

public interface ActorService {

    List<ActorDTO> findAll();

    ActorDTO findById(int id);

    void saveOrUpdate(ActorDTO actor);

    void delete(ActorDTO actor);

    void delete(int id);

    List<ActorDTO> findByCountryEqualsAndLastNameEndsWithAndAgeLessThan(String country, String endsWith, int years);

    List<ActorDTO> findByGenderAndFromCountry(Gender gender, String country);

    List<ActorDTO> findByMoviesMoreThanAndBornInTwentiethCentury(long amount);
}
