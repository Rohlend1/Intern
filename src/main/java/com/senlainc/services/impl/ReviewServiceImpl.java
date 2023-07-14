package com.senlainc.services.impl;

import com.senlainc.dto.reviews.ReviewDTO;
import com.senlainc.dto.users.UserDTO;
import com.senlainc.models.Review;
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

    public List<ReviewDTO> findAll() {
        return converter.convertListToReviewDTO(reviewRepository.findAll());
    }

    public ReviewDTO findById(int id) {
        return converter.convertToReviewDTO(reviewRepository.findById(id));
    }

    public void saveOrUpdate(ReviewDTO reviewDTO){
        reviewRepository.saveOrUpdate(converter.convertToReview(reviewDTO));
    }

    public void delete(ReviewDTO reviewDTO){
        reviewRepository.delete(converter.convertToReview(reviewDTO));
    }

    public void delete(int id) {
        reviewRepository.delete(id);
    }

    public List<ReviewDTO> findByUser(UserDTO userDTO) {
        User user = converter.convertToUser(userDTO);
        return converter.convertListToReviewDTO(reviewRepository.findByUser(user));
    }

    public List<ReviewDTO> findAllPagination(int page, int reviewsPerPage) {
        return converter.convertListToReviewDTO(reviewRepository.findAllPagination(page, reviewsPerPage));
    }

    public List<ReviewDTO> findByContentGreaterThanAndUpdated(int amountOfCharacters) {
        return converter.convertListToReviewDTO(reviewRepository.findByContentGreaterThanAndUpdated(amountOfCharacters));
    }

    public List<ReviewDTO> findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(int month, int minutes, int year) {
        return converter.convertListToReviewDTO(reviewRepository.findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(month, minutes, year));
    }
}
