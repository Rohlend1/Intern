package com.senlainc.services.impl;

import com.senlainc.dto.reviews.ReviewDto;
import com.senlainc.dto.users.UserDto;
import com.senlainc.models.User;
import com.senlainc.repositories.ReviewRepository;
import com.senlainc.services.ReviewService;
import com.senlainc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final Converter converter;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, Converter converter) {
        this.reviewRepository = reviewRepository;
        this.converter = converter;
    }

    public List<ReviewDto> findAll() {
        return converter.convertListToReviewDTO(reviewRepository.findAll());
    }

    public ReviewDto findById(int id) {
        return converter.convertToReviewDTO(reviewRepository.findById(id));
    }

    public void saveOrUpdate(ReviewDto reviewDTO){
        reviewRepository.saveOrUpdate(converter.convertToReview(reviewDTO));
    }

    public void delete(ReviewDto reviewDTO){
        reviewRepository.delete(converter.convertToReview(reviewDTO));
    }

    public void delete(int id) {
        reviewRepository.delete(id);
    }

    public List<ReviewDto> findByUser(UserDto userDTO) {
        User user = converter.convertToUser(userDTO);
        return converter.convertListToReviewDTO(reviewRepository.findByUser(user));
    }

    public List<ReviewDto> findWithPagination(int page, int reviewsPerPage) {
        return converter.convertListToReviewDTO(reviewRepository.findWithPagination(page, reviewsPerPage));
    }

    public List<ReviewDto> findByContentSizeAndEdit(int charsAmount) {
        return converter.convertListToReviewDTO(reviewRepository.findByContentGreaterThanAndUpdated(charsAmount));
    }

    public List<ReviewDto> findByMonthAndDifferentPeriod(int month, int minutes, int year) {
        return converter.convertListToReviewDTO(reviewRepository.findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(month, minutes, year));
    }
}
