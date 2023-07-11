package com.senlainc.controllers;

import com.senlainc.dto.genres.AmountAndDurationSearchDTO;
import com.senlainc.dto.genres.GenreDTO;
import com.senlainc.errors.ModelNotFoundException;
import com.senlainc.models.Genre;
import com.senlainc.services.GenreService;
import com.senlainc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @Autowired
    private Converter converter;

    @GetMapping
    public List<GenreDTO> getGenres(){
        return converter.convertListToGenreDTO(genreService.findAll());
    }

    @GetMapping("/{id}")
    public GenreDTO getGenre(@PathVariable("id") int id){
        return converter.convertToGenreDTO(genreService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable("id") int id){
        try{
            Genre genre = genreService.findById(id);
            genreService.delete(genre);
        }
        catch (ModelNotFoundException e){
            System.out.println("No genre with this id was found");
        }
    }

    @PatchMapping
    public void updateGenre(@RequestBody GenreDTO genreDTO){
        genreService.saveOrUpdate(converter.convertToGenre(genreDTO));
    }

    @PostMapping
    public void createGenre(@RequestBody GenreDTO genreDTO){
        genreService.saveOrUpdate(converter.convertToGenre(genreDTO));
    }

    @GetMapping("/amount_duration")
    public List<GenreDTO> getGenreByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(@RequestBody AmountAndDurationSearchDTO dto){
        return converter.convertListToGenreDTO(genreService.findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(dto.getAmount(), dto.getDuration()));
    }

    @GetMapping("/like")
    public List<GenreDTO> getGenreLike(@RequestParam("character") Character ch){
        return converter.convertListToGenreDTO(genreService.findGenreLike(ch));
    }

    @GetMapping("/most_popular")
    public GenreDTO getMostPopularGenre(){
        return converter.convertToGenreDTO(genreService.findMostPopularGenre());
    }
}
