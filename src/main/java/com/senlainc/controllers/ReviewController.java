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

    @GetMapping
    public List<ReviewDTO> getReviews(){
        return Converter.convertListToReviewDTO(reviewService.findAll());
    }

    @GetMapping("/{id}")
    public ReviewDTO getReview(@PathVariable("id") int id){
        return Converter.convertToReviewDTO(reviewService.findById(id));
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
        reviewService.saveOrUpdate(Converter.convertToReview(reviewDTO));
    }

    @PostMapping
    public void createReview(ReviewDTO reviewDTO){
        reviewService.saveOrUpdate(Converter.convertToReview(reviewDTO));
    }

    @GetMapping("/month_minutes_year")
    public List<ReviewDTO> getReviewByMonthEqualsMinuteDiffLessThanYearOfCreationEquals(@RequestBody MonthAndMinutesAndYearSearch dto){
        return Converter.convertListToReviewDTO(reviewService.findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(dto.getMonth(), dto.getMinutes(), dto.getYear()));
    }

    @GetMapping("/find_by_user")
    public List<ReviewDTO> getReviewsByUser(@RequestBody UserDTO dto){
        User user = Converter.convertToUser(dto);
        return Converter.convertListToReviewDTO(reviewService.findByUser(user));
    }

    @GetMapping("/amount_of_characters")
    public List<ReviewDTO> getReviewByContentGreaterThanAndUpdated(@RequestParam("amount_of_characters") Integer amountOfCharacters){
        return Converter.convertListToReviewDTO(reviewService.findByContentGreaterThanAndUpdated(amountOfCharacters));
    }

    @GetMapping("/pagination")
    public List<ReviewDTO> getReviewsPagination(@RequestBody PaginationSearch dto){
        return Converter.convertListToReviewDTO(reviewService.findAllPagination(dto.getPage(), dto.getItemsPerPage()));
    }
}
