package com.senlainc.controllers;

import com.senlainc.dto.genres.AmountAndDurationSearchDto;
import com.senlainc.dto.genres.GenreDto;
import com.senlainc.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/all")
    public List<GenreDto> getGenres(){
        return genreService.findAll();
    }

    @GetMapping("/{id}")
    public GenreDto getGenre(@PathVariable("id") int id){
        return genreService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable("id") int id){
        genreService.delete(id);
    }

    @PutMapping
    public void saveOrUpdateGenre(@RequestBody GenreDto genreDTO){
        genreService.saveOrUpdate(genreDTO);
    }

    @GetMapping("/find/movies/amount/duration")
    public List<GenreDto> getGenreByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(@RequestBody AmountAndDurationSearchDto dto){
        return genreService.findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(dto.getAmount(), dto.getDuration());
    }

    @GetMapping("/find/like")
    public List<GenreDto> getGenreLike(@RequestParam("character") Character ch){
        return genreService.findGenreLike(ch);
    }

    @GetMapping("/find/most-popular")
    public GenreDto getMostPopularGenre(){
        return genreService.findMostPopularGenre();
    }
}
