package com.senlainc.services;

import com.senlainc.dto.reviews.ReviewDTO;
import com.senlainc.dto.users.UserDTO;
import com.senlainc.models.Review;
import com.senlainc.models.User;

import java.util.List;

public interface ReviewService {

    List<ReviewDTO> findAll();

    ReviewDTO findById(int id);

    void saveOrUpdate(ReviewDTO review);

    void delete(ReviewDTO review);

    void delete(int id);

    List<ReviewDTO> findByUser(UserDTO user);

    List<ReviewDTO> findAllPagination(int page, int reviewsPerPage);

    List<ReviewDTO> findByContentGreaterThanAndUpdated(int amountOfCharacters);

    List<ReviewDTO> findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(int month, int minutes, int year);
}
