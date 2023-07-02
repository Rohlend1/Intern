package com.senlainc.services;

import com.senlainc.util.DatabasePreparer;
import com.senlainc.config.SpringConfig;
import com.senlainc.models.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestUserService {

    private static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    private final UserService userService = context.getBean(UserService.class);

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
    public void testFindTotalUsersWith(){
        assertEquals(2L,(long) userService.findTotalUsersWithNoEditedReviews());
    }

    @Test
    public void testFindByUsernameConsistsOfTextAndHasAtLeastOneReview(){
        List<User> actualUsers = userService.findByUsernameConsistsOfTextAndHasAtLeastOneReview();
        assertEquals(2,actualUsers.size());
        List<User> expectedUsers = new ArrayList<>();
        expectedUsers.add(userService.findByUsername("Ark"));
        expectedUsers.add(userService.findByUsername("Frog"));
        actualUsers.sort(Comparator.comparingInt(User::getId));
        assertEquals(expectedUsers,actualUsers);
    }

    @Test
    public void testFindByUsernameMatchingToRegexp(){
        assertEquals(userService.findByUsername("Frog"),userService.findByUsernameMatchingToRegexp("[F]+").get(0));
    }
}
