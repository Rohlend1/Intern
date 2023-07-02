package com.senlainc.services;

import com.senlainc.config.SpringConfig;
import com.senlainc.models.Review;
import com.senlainc.util.DatabasePreparer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestReviewService {

    private static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final ReviewService reviewService = context.getBean(ReviewService.class);

    @BeforeAll
    public static void prepareDatabase(){
        DatabasePreparer.clearDatabase(context);
        DatabasePreparer.prepareDatabase(context);
    }

    @AfterAll
    public static void clearDatabase(){
        DatabasePreparer.clearDatabase(context);
    }

    @Test
    public void testFindAllPagination(){
        List<Review> expectedReviews = new ArrayList<>();
        List<Review> actualReviews = reviewService.findAllPagination(1,2);

        expectedReviews.add(reviewService.findById(DatabasePreparer.reviews.get(0).getId()));
        expectedReviews.add(reviewService.findById(DatabasePreparer.reviews.get(1).getId()));

        actualReviews.sort(Comparator.comparingInt(Review::getId));
        expectedReviews.sort(Comparator.comparingInt(Review::getId));

        assertEquals(expectedReviews,actualReviews);
    }

    @Test
    public void testFindByContentGreaterThanAndUpdated(){
        List<Review> expectedReviews = new ArrayList<>();
        List<Review> actualReviews = reviewService.findByContentGreaterThanAndUpdated(18);

        expectedReviews.add(reviewService.findById(DatabasePreparer.reviews.get(3).getId()));

        actualReviews.sort(Comparator.comparingInt(Review::getId));
        expectedReviews.sort(Comparator.comparingInt(Review::getId));

        assertEquals(expectedReviews,actualReviews);
    }

    @Test
    public void testFindMonthEqualsMinuteDiffLessThanYearOfCreationEquals(){
        List<Review> expectedReviews = new ArrayList<>();
        List<Review> actualReviews = reviewService.findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(6,10_000_000,2017);

        expectedReviews.add(reviewService.findById(DatabasePreparer.reviews.get(1).getId()));

        actualReviews.sort(Comparator.comparingInt(Review::getId));
        expectedReviews.sort(Comparator.comparingInt(Review::getId));

        assertEquals(expectedReviews,actualReviews);
    }

    @Test
    public void testFindByUser(){
        List<Review> expectedReviews = new ArrayList<>();
        UserService userService = context.getBean(UserService.class);
        List<Review> actualReviews = reviewService.findByUser(userService.findByUsername("Ark"));

        expectedReviews.add(reviewService.findById(DatabasePreparer.reviews.get(0).getId()));
        expectedReviews.add(reviewService.findById(DatabasePreparer.reviews.get(1).getId()));

        actualReviews.sort(Comparator.comparingInt(Review::getId));
        expectedReviews.sort(Comparator.comparingInt(Review::getId));

        assertEquals(expectedReviews,actualReviews);
    }
}
