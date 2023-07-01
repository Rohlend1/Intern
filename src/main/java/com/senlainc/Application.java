package com.senlainc;

import com.senlainc.config.SpringConfig;
import com.senlainc.models.User;
import com.senlainc.services.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ReviewService reviewService = context.getBean(ReviewService.class);

        UserService userService = context.getBean(UserService.class);

        System.out.println(reviewService.findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(2,6,2023));

        System.out.println(reviewService.findContentGreaterThanAndUpdated(1));

        System.out.println(reviewService.findAllPagination(0,1));

        System.out.println(reviewService.findByUser(userService.findById(50)));
    }
}
