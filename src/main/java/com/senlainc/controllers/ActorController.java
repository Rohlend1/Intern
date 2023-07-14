package com.senlainc.controllers;

import com.senlainc.dto.actors.ActorDTO;
import com.senlainc.dto.actors.CountryAndLastNameAndAgeSearchDTO;
import com.senlainc.dto.actors.GenderAndCountrySearchDTO;
import com.senlainc.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping
    public List<ActorDTO> getActors(){
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public ActorDTO getActor(@PathVariable("id") int id){
        return actorService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable("id") int id){
       actorService.delete(id);
    }

    @PatchMapping
    public void updateActor(@RequestBody ActorDTO actorDTO){
        actorService.saveOrUpdate(actorDTO);
    }

    @PostMapping
    public void createActor(@RequestBody ActorDTO actorDTO){
        actorService.saveOrUpdate(actorDTO);
    }

    @GetMapping("/gender_country")
    public List<ActorDTO> getActorByGenderAndFromCountry(@RequestBody GenderAndCountrySearchDTO dto){
        return actorService.findByGenderAndFromCountry(dto.getGender(), dto.getCountry());
    }

    @GetMapping("/movies_born")
    public List<ActorDTO> getActorByMoviesMoreThanAndBornInTwentiethCentury(@RequestParam("amount") Long amount){
        return actorService.findByMoviesMoreThanAndBornInTwentiethCentury(amount);
    }

    @GetMapping("/country_ends_with")
    public List<ActorDTO> getActorByCountryEqualsAndLastNameEndsWithAndAgeLessThan(@RequestBody CountryAndLastNameAndAgeSearchDTO dto){
        return actorService.findByCountryEqualsAndLastNameEndsWithAndAgeLessThan(dto.getCountry(), dto.getEndsWith(), dto.getAge());
    }
}
