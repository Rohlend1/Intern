package com.senlainc.services.impl;

import com.senlainc.models.Review;
import com.senlainc.models.User;
import com.senlainc.repositories.ReviewRepository;
import com.senlainc.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review findById(int id) {
        return reviewRepository.findById(id);
    }

    public void saveOrUpdate(Review review){
        reviewRepository.saveOrUpdate(review);
    }

    public void delete(Review review){
        reviewRepository.delete(review);
    }

    public List<Review> findByUser(User user) {
        return reviewRepository.findByUser(user);
    }

    public List<Review> findAllPagination(int page, int reviewsPerPage) {
        return reviewRepository.findAllPagination(page, reviewsPerPage);
    }

    public List<Review> findByContentGreaterThanAndUpdated(int amountOfCharacters) {
        return reviewRepository.findByContentGreaterThanAndUpdated(amountOfCharacters);
    }

    public List<Review> findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(int month, int minutes, int year) {
        return reviewRepository.findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(month, minutes, year);
    }
}
