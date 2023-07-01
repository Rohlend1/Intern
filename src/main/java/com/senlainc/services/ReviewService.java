package com.senlainc.services;

import com.senlainc.models.Review;
import com.senlainc.models.User;
import com.senlainc.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review findById(int id) {
        return reviewRepository.findById(id);
    }

    public void save(Review review) {
        reviewRepository.save(review);
    }

    public void delete(Review review) {
        reviewRepository.delete(review);
    }

    public void update(int id, Review review) {
        reviewRepository.delete(reviewRepository.findById(id));
        review.setId(id);
        reviewRepository.save(review);
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

    public List<Review> findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(int minutes, int month, int year) {
        return reviewRepository.findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(minutes, month, year);
    }
}
