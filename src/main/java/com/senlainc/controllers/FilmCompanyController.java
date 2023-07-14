package com.senlainc.controllers;

import com.senlainc.dto.filmcompanies.FilmCompanyDto;
import com.senlainc.dto.DateBetweenSearchDto;
import com.senlainc.services.FilmCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film_companies")
public class FilmCompanyController {

    @Autowired
    private FilmCompanyService filmCompanyService;

    @GetMapping("/all")
    public List<FilmCompanyDto> getFilmCompanies(){
        return filmCompanyService.findAll();
    }

    @GetMapping("/{id}")
    public FilmCompanyDto getFilmCompany(@PathVariable("id") int id){
        return filmCompanyService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFilmCompany(@PathVariable("id") int id){
        filmCompanyService.delete(id);
    }

    @PutMapping
    public void saveOrUpdateFilmCompany(@RequestBody FilmCompanyDto filmCompanyDTO){
        filmCompanyService.saveOrUpdate(filmCompanyDTO);
    }

    @GetMapping("/find/foundation-date")
    public List<FilmCompanyDto> getFilmCompanyByDateOfFoundationLessThan(@RequestParam("years") Integer years){
        return filmCompanyService.findByDateOfFoundationLessThan(years);
    }

    @GetMapping("/find/all/name-sorted")
    public List<FilmCompanyDto> getFilmCompaniesSortByName(){
        return filmCompanyService.findAllSortByName();
    }

    @GetMapping("/find/least-popular")
    public FilmCompanyDto getLeastPopularFilmCompany(){
        return filmCompanyService.findLeastPopularFilmCompany();
    }

    @GetMapping("/find/name")
    public FilmCompanyDto getFilmCompanyByName(@RequestParam("name") String name){
        return filmCompanyService.findByName(name);
    }

    @GetMapping("/find/foundation-date/between")
    public List<FilmCompanyDto> getFilmCompanyByNameWithTwoWordsAndDateOfFoundationBetween(@RequestBody DateBetweenSearchDto dto){
        return filmCompanyService.findByNameWithTwoWordsAndDateOfFoundationBetween(dto.getYear1(), dto.getYear2());
    }
}
