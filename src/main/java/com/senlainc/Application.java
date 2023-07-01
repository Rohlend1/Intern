package com.senlainc;

import com.senlainc.config.SpringConfig;
import com.senlainc.services.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        CommentService commentService = context.getBean(CommentService.class);
        ReviewService reviewService = context.getBean(ReviewService.class);
        UserService userService = context.getBean(UserService.class);

        System.out.println(userService.findTotalUsersWithNoEditedReviews());

        System.out.println(userService.findByUsernameMatchingToRegexp("[A]+"));

        System.out.println(userService.findByUsernameConsistsOfTextAndHasAtLeastOneReview());

    }
}
