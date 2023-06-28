package com.senlainc.repositories;

import com.senlainc.errors.ModelNotFoundException;
import com.senlainc.models.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewRepository {

    private final List<Review> reviews = new ArrayList<>();

    public List<Review> findAll() {
        return reviews;
    }

    public void save(Review review) {
        reviews.add(review);
    }

    public Review findOne(Review review){
        return reviews.stream().filter(a->a.equals(review)).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public Review findById(int id){
        return reviews.stream().filter(a->a.getId()==id).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public void delete(Review review){
        reviews.remove(review);
    }
}
