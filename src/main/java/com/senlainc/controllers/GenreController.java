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

    @GetMapping
    public List<GenreDTO> getGenres(){
        return Converter.convertListToGenreDTO(genreService.findAll());
    }

    @GetMapping("/{id}")
    public GenreDTO getGenre(@PathVariable("id") int id){
        return Converter.convertToGenreDTO(genreService.findById(id));
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
    public void updateGenre(GenreDTO genreDTO){
        genreService.saveOrUpdate(Converter.convertToGenre(genreDTO));
    }

    @PostMapping
    public void createGenre(GenreDTO genreDTO){
        genreService.saveOrUpdate(Converter.convertToGenre(genreDTO));
    }

    @GetMapping("/amount_duration")
    public List<GenreDTO> getGenreByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(@RequestBody AmountAndDurationSearchDTO dto){
        return Converter.convertListToGenreDTO(genreService.findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(dto.getAmount(), dto.getDuration()));
    }

    @GetMapping("/like")
    public List<GenreDTO> getGenreLike(@RequestParam("character") Character ch){
        return Converter.convertListToGenreDTO(genreService.findGenreLike(ch));
    }

    @GetMapping("/most_popular")
    public GenreDTO getMostPopularGenre(){
        return Converter.convertToGenreDTO(genreService.findMostPopularGenre());
    }
}
