package com.senlainc.services;

import com.senlainc.models.Review;
import com.senlainc.models.User;

import java.util.List;

public interface ReviewService {

    List<Review> findAll();

    Review findById(int id);

    void saveOrUpdate(Review review);

    void delete(Review review);

    List<Review> findByUser(User user);

    List<Review> findAllPagination(int page, int reviewsPerPage);

    List<Review> findByContentGreaterThanAndUpdated(int amountOfCharacters);

    List<Review> findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(int month, int minutes, int year);
}
