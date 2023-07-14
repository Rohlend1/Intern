package com.senlainc.services;

import com.senlainc.dto.reviews.ReviewDto;
import com.senlainc.dto.users.UserDto;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> findAll();

    ReviewDto findById(int id);

    void saveOrUpdate(ReviewDto review);

    void delete(ReviewDto review);

    void delete(int id);

    List<ReviewDto> findByUser(UserDto user);

    List<ReviewDto> findWithPagination(int page, int reviewsPerPage);

    List<ReviewDto> findByContentSizeAndEdit(int charsAmount);

    List<ReviewDto> findByMonthAndDifferentPeriod(int month, int minutes, int year);
}
