package com.senlainc.controllers;

import com.senlainc.dto.genres.AmountAndDurationSearchDTO;
import com.senlainc.dto.genres.GenreDTO;
import com.senlainc.services.GenreService;
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
        return genreService.findAll();
    }

    @GetMapping("/{id}")
    public GenreDTO getGenre(@PathVariable("id") int id){
        return genreService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable("id") int id){
        genreService.delete(id);
    }

    @PatchMapping
    public void updateGenre(@RequestBody GenreDTO genreDTO){
        genreService.saveOrUpdate(genreDTO);
    }

    @PostMapping
    public void createGenre(@RequestBody GenreDTO genreDTO){
        genreService.saveOrUpdate(genreDTO);
    }

    @GetMapping("/amount_duration")
    public List<GenreDTO> getGenreByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(@RequestBody AmountAndDurationSearchDTO dto){
        return genreService.findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(dto.getAmount(), dto.getDuration());
    }

    @GetMapping("/like")
    public List<GenreDTO> getGenreLike(@RequestParam("character") Character ch){
        return genreService.findGenreLike(ch);
    }

    @GetMapping("/most_popular")
    public GenreDTO getMostPopularGenre(){
        return genreService.findMostPopularGenre();
    }
}
