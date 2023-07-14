package com.senlainc.controllers;

import com.senlainc.dto.PaginationDto;
import com.senlainc.dto.reviews.MonthAndMinutesAndYearSearchDto;
import com.senlainc.dto.reviews.ReviewDto;
import com.senlainc.dto.users.UserDto;
import com.senlainc.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/all")
    public List<ReviewDto> getReviews(){
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDto getReview(@PathVariable("id") int id){
        return reviewService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable("id") int id){
        reviewService.delete(id);
    }

    @PutMapping
    public void saveOrUpdateReview(@RequestBody ReviewDto reviewDTO){
        reviewService.saveOrUpdate(reviewDTO);
    }

    @GetMapping("/find/month/different-period")
    public List<ReviewDto> getByMonthAndDifferentPeriod(@RequestBody MonthAndMinutesAndYearSearchDto dto){
        return reviewService.findByMonthAndDifferentPeriod(dto.getMonth(), dto.getMinutes(), dto.getYear());
    }

    @GetMapping("/find/user")
    public List<ReviewDto> getReviewsByUser(@RequestBody UserDto dto){
        return reviewService.findByUser(dto);
    }

    @GetMapping("/find/content-size/edit")
    public List<ReviewDto> getByContentSizeAndEdit(@RequestParam("amount_of_characters") Integer charsAmount){
        return reviewService.findByContentSizeAndEdit(charsAmount);
    }

    @GetMapping("/find/page")
    public List<ReviewDto> getPaginatedReviews(@RequestBody PaginationDto dto){
        return reviewService.findWithPagination(dto.getPage(), dto.getItemsPerPage());
    }
}
