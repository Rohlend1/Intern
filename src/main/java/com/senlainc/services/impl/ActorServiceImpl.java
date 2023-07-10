package com.senlainc.services.impl;

import com.senlainc.models.Actor;
import com.senlainc.repositories.ActorRepository;
import com.senlainc.services.ActorService;
import com.senlainc.util.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> findAll(){
        return actorRepository.findAll();
    }

    public Actor findById(int id){
        return actorRepository.findById(id);
    }

    public void saveOrUpdate(Actor actor){
        actorRepository.saveOrUpdate(actor);
    }

    public void delete(Actor actor){
        actorRepository.delete(actor);
    }

    public List<Actor> findByCountryEqualsAndLastNameEndsWithAndAgeLessThan(String country, String endsWith, int years){
        return actorRepository.findByCountryEqualsAndLastNameEndsWithAndAgeLessThan(country, "%"+endsWith, years);
    }

    public List<Actor> findByGenderAndFromCountry(Gender gender, String country) {
        return actorRepository.findByGenderAndFromCountry(gender, country);
    }

    public List<Actor> findByMoviesMoreThanAndBornInTwentiethCentury(long amount) {
        return actorRepository.findByMoviesMoreThanAndBornInTwentiethCentury(amount);
    }
}
