package com.senlainc.controllers;

import com.senlainc.dto.actors.ActorDTO;
import com.senlainc.dto.actors.CountryAndLastNameAndAgeSearchDTO;
import com.senlainc.dto.actors.GenderAndCountrySearchDTO;
import com.senlainc.errors.ModelNotFoundException;
import com.senlainc.models.Actor;
import com.senlainc.services.ActorService;
import com.senlainc.util.Converter;
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
        return Converter.convertListToActorDTO(actorService.findAll());
    }

    @GetMapping("/{id}")
    public ActorDTO getActor(@PathVariable("id") int id){
        return Converter.convertToActorDTO(actorService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable("id") int id){
        try{
           Actor actor = actorService.findById(id);
           actorService.delete(actor);
        }
        catch (ModelNotFoundException e){
            System.out.println("No actor with this id was found");
        }
    }

    @PatchMapping
    public void updateActor(ActorDTO actorDTO){
        actorService.saveOrUpdate(Converter.convertToActor(actorDTO));
    }

    @PostMapping
    public void createActor(ActorDTO actorDTO){
        actorService.saveOrUpdate(Converter.convertToActor(actorDTO));
    }

    @GetMapping("/gender_country")
    public List<ActorDTO> getActorByGenderAndFromCountry(@RequestBody GenderAndCountrySearchDTO dto){
        return Converter.convertListToActorDTO(actorService.findByGenderAndFromCountry(dto.getGender(), dto.getCountry()));
    }

    @GetMapping("/movies_born")
    public List<ActorDTO> getActorByMoviesMoreThanAndBornInTwentiethCentury(@RequestParam("amount") Long amount){
        return Converter.convertListToActorDTO(actorService.findByMoviesMoreThanAndBornInTwentiethCentury(amount));
    }

    @GetMapping("/country_ends_with")
    public List<ActorDTO> getActorByCountryEqualsAndLastNameEndsWithAndAgeLessThan(@RequestBody CountryAndLastNameAndAgeSearchDTO dto){
        return Converter.convertListToActorDTO(actorService.findByCountryEqualsAndLastNameEndsWithAndAgeLessThan(dto.getCountry(), dto.getEndsWith(), dto.getYears()));
    }
}
