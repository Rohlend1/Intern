package com.senlainc.repositories;

import com.senlainc.models.Review;
import com.senlainc.models.User;

import java.util.List;

public interface ReviewRepository {

    List<Review> findAll();

    void saveOrUpdate(Review review);

    Review findById(int id);

    void delete(Review review);

    void delete(int id);

    List<Review> findByUser(User user);

    List<Review> findAllPagination(int page, int moviesPerPage);

    List<Review> findByContentGreaterThanAndUpdated(int amountOfCharacters);

    List<Review> findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(int month, int minutes, int year);
}
