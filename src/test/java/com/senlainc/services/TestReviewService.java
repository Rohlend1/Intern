package com.senlainc.services;

import com.senlainc.config.SpringConfig;
import com.senlainc.models.Review;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
@Transactional
public class TestReviewService {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;

    @Test
    public void testFindAllPagination(){
        List<Review> expectedReviews = new ArrayList<>();
        List<Review> actualReviews = reviewService.findAllPagination(1,2);

        expectedReviews.add(reviewService.findById(1));
        expectedReviews.add(reviewService.findById(2));

        actualReviews.sort(Comparator.comparingInt(Review::getId));
        expectedReviews.sort(Comparator.comparingInt(Review::getId));

        assertEquals(expectedReviews,actualReviews);
    }

    @Test
    public void testFindByContentGreaterThanAndUpdated(){
        List<Review> expectedReviews = new ArrayList<>();
        List<Review> actualReviews = reviewService.findByContentGreaterThanAndUpdated(18);

        expectedReviews.add(reviewService.findById(4));

        actualReviews.sort(Comparator.comparingInt(Review::getId));
        expectedReviews.sort(Comparator.comparingInt(Review::getId));

        assertEquals(expectedReviews,actualReviews);
    }

    @Test
    public void testFindMonthEqualsMinuteDiffLessThanYearOfCreationEquals(){
        List<Review> expectedReviews = new ArrayList<>();
        List<Review> actualReviews = reviewService.findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(6,10_000_000,2017);

        expectedReviews.add(reviewService.findById(2));

        actualReviews.sort(Comparator.comparingInt(Review::getId));
        expectedReviews.sort(Comparator.comparingInt(Review::getId));

        assertEquals(expectedReviews,actualReviews);
    }

    @Test
    public void testFindByUser(){
        List<Review> expectedReviews = new ArrayList<>();
        List<Review> actualReviews = reviewService.findByUser(userService.findByUsername("Ark"));

        expectedReviews.add(reviewService.findById(1));
        expectedReviews.add(reviewService.findById(2));

        actualReviews.sort(Comparator.comparingInt(Review::getId));
        expectedReviews.sort(Comparator.comparingInt(Review::getId));

        assertEquals(expectedReviews,actualReviews);
    }
}
