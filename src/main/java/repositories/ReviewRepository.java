package repositories;

import models.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewRepository {

    private List<Review> reviews;

    public List<Review> findAll() {
        return reviews;
    }

    public void save(Review review) {
        reviews.add(review);
    }

    public Review findOne(Review review){
        return reviews.stream().filter(a->a.equals(review)).findAny().orElse(null);
    }

    public Review findById(int id){
        return reviews.stream().filter(a->a.getId()==id).findAny().orElse(null);
    }

    public void delete(Review review){
        reviews.remove(review);
    }
}
