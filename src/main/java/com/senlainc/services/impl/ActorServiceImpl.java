package com.senlainc.services.impl;

import com.senlainc.dto.actors.ActorDto;
import com.senlainc.repositories.ActorRepository;
import com.senlainc.services.ActorService;
import com.senlainc.util.Converter;
import com.senlainc.util.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    private final Converter converter;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository, Converter converter) {
        this.actorRepository = actorRepository;
        this.converter = converter;
    }

    public List<ActorDto> findAll(){
        return converter.convertListToActorDTO(actorRepository.findAll());
    }

    public ActorDto findById(int id){
        return converter.convertToActorDTO(actorRepository.findById(id));
    }

    public void saveOrUpdate(ActorDto actorDTO){
        actorRepository.saveOrUpdate(converter.convertToActor(actorDTO));
    }

    public void delete(ActorDto actorDTO){
        actorRepository.delete(converter.convertToActor(actorDTO));
    }

    public void delete(int id) {
        actorRepository.delete(id);
    }

    public List<ActorDto> findByCountryEqualsAndLastNameEndsWithAndAgeLessThan(String country, String endsWith, int years){
        return converter.convertListToActorDTO(actorRepository.findByCountryEqualsAndLastNameEndsWithAndAgeLessThan(country, "%"+endsWith, years));
    }

    public List<ActorDto> findByGenderAndFromCountry(Gender gender, String country) {
        return converter.convertListToActorDTO(actorRepository.findByGenderAndFromCountry(gender, country));
    }

    public List<ActorDto> findByMoviesMoreThanAndBornInTwentiethCentury(long amount) {
        return converter.convertListToActorDTO(actorRepository.findByMoviesMoreThanAndBornInTwentiethCentury(amount));
    }
}
