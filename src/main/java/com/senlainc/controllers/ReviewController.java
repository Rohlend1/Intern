package com.senlainc.controllers;

import com.senlainc.dto.PaginationSearch;
import com.senlainc.dto.reviews.MonthAndMinutesAndYearSearch;
import com.senlainc.dto.reviews.ReviewDTO;
import com.senlainc.dto.users.UserDTO;
import com.senlainc.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<ReviewDTO> getReviews(){
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDTO getReview(@PathVariable("id") int id){
        return reviewService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable("id") int id){
        reviewService.delete(id);
    }

    @PatchMapping
    public void updateReview(@RequestBody ReviewDTO reviewDTO){
        reviewService.saveOrUpdate(reviewDTO);
    }

    @PostMapping
    public void createReview(@RequestBody ReviewDTO reviewDTO){
        reviewService.saveOrUpdate(reviewDTO);
    }

    @GetMapping("/month_minutes_year")
    public List<ReviewDTO> getReviewByMonthEqualsMinuteDiffLessThanYearOfCreationEquals(@RequestBody MonthAndMinutesAndYearSearch dto){
        return reviewService.findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(dto.getMonth(), dto.getMinutes(), dto.getYear());
    }

    @GetMapping("/find_by_user")
    public List<ReviewDTO> getReviewsByUser(@RequestBody UserDTO dto){
        return reviewService.findByUser(dto);
    }

    @GetMapping("/amount_of_characters")
    public List<ReviewDTO> getReviewByContentGreaterThanAndUpdated(@RequestParam("amount_of_characters") Integer amountOfCharacters){
        return reviewService.findByContentGreaterThanAndUpdated(amountOfCharacters);
    }

    @GetMapping("/pagination")
    public List<ReviewDTO> getReviewsPagination(@RequestBody PaginationSearch dto){
        return reviewService.findAllPagination(dto.getPage(), dto.getItemsPerPage());
    }
}
