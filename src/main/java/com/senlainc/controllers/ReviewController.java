package com.senlainc.controllers;

import com.senlainc.dto.PaginationSearch;
import com.senlainc.dto.reviews.MonthAndMinutesAndYearSearch;
import com.senlainc.dto.reviews.ReviewDTO;
import com.senlainc.dto.users.UserDTO;
import com.senlainc.errors.ModelNotFoundException;
import com.senlainc.models.Review;
import com.senlainc.models.User;
import com.senlainc.services.ReviewService;
import com.senlainc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    
    @Autowired
    private Converter converter;

    @GetMapping
    public List<ReviewDTO> getReviews(){
        return converter.convertListToReviewDTO(reviewService.findAll());
    }

    @GetMapping("/{id}")
    public ReviewDTO getReview(@PathVariable("id") int id){
        return converter.convertToReviewDTO(reviewService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable("id") int id){
        try{
            Review review = reviewService.findById(id);
            reviewService.delete(review);
        }
        catch (ModelNotFoundException e){
            System.out.println("No genre with this id was found");
        }
    }

    @PatchMapping
    public void updateReview(ReviewDTO reviewDTO){
        reviewService.saveOrUpdate(converter.convertToReview(reviewDTO));
    }

    @PostMapping
    public void createReview(ReviewDTO reviewDTO){
        reviewService.saveOrUpdate(converter.convertToReview(reviewDTO));
    }

    @GetMapping("/month_minutes_year")
    public List<ReviewDTO> getReviewByMonthEqualsMinuteDiffLessThanYearOfCreationEquals(@RequestBody MonthAndMinutesAndYearSearch dto){
        return converter.convertListToReviewDTO(reviewService.findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(dto.getMonth(), dto.getMinutes(), dto.getYear()));
    }

    @GetMapping("/find_by_user")
    public List<ReviewDTO> getReviewsByUser(@RequestBody UserDTO dto){
        User user = converter.convertToUser(dto);
        return converter.convertListToReviewDTO(reviewService.findByUser(user));
    }

    @GetMapping("/amount_of_characters")
    public List<ReviewDTO> getReviewByContentGreaterThanAndUpdated(@RequestParam("amount_of_characters") Integer amountOfCharacters){
        return converter.convertListToReviewDTO(reviewService.findByContentGreaterThanAndUpdated(amountOfCharacters));
    }

    @GetMapping("/pagination")
    public List<ReviewDTO> getReviewsPagination(@RequestBody PaginationSearch dto){
        return converter.convertListToReviewDTO(reviewService.findAllPagination(dto.getPage(), dto.getItemsPerPage()));
    }
}
