package com.senlainc.controllers;

import com.senlainc.dto.actors.ActorDto;
import com.senlainc.dto.actors.CountryAndLastNameAndAgeSearchDto;
import com.senlainc.dto.actors.GenderAndCountrySearchDto;
import com.senlainc.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/all")
    public List<ActorDto> getActors(){
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public ActorDto getActor(@PathVariable("id") int id){
        return actorService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable("id") int id){
       actorService.delete(id);
    }

    @PutMapping
    public void saveOrUpdateActor(@RequestBody ActorDto actorDTO){
        actorService.saveOrUpdate(actorDTO);
    }

    @GetMapping("/find/gender/country")
    public List<ActorDto> getActorByGenderAndFromCountry(@RequestBody GenderAndCountrySearchDto dto){
        return actorService.findByGenderAndFromCountry(dto.getGender(), dto.getCountry());
    }

    @GetMapping("/find/twentieth-century/movies")
    public List<ActorDto> getActorByMoviesMoreThanAndBornInTwentiethCentury(@RequestParam("amount") Long amount){
        return actorService.findByMoviesMoreThanAndBornInTwentiethCentury(amount);
    }

    @GetMapping("/find/country/ends-with/age")
    public List<ActorDto> getActorByCountryEqualsAndLastNameEndsWithAndAgeLessThan(@RequestBody CountryAndLastNameAndAgeSearchDto dto){
        return actorService.findByCountryEqualsAndLastNameEndsWithAndAgeLessThan(dto.getCountry(), dto.getEndsWith(), dto.getAge());
    }
}
