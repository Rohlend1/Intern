package com.senlainc.services;

import com.senlainc.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senlainc.repositories.ReviewRepository;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAll(){
        return reviewRepository.findAll();
    }

    public Review findById(int id){
        return reviewRepository.findById(id);
    }

    public void save(Review review){
        reviewRepository.save(review);
    }

    public void delete(Review review){
        reviewRepository.delete(review);
    }

    public void update(int id, Review review){
        reviewRepository.delete(reviewRepository.findById(id));
        review.setId(id);
        reviewRepository.save(review);
    }
}
