package com.senlainc.services;

import com.senlainc.config.SpringConfig;
import com.senlainc.models.User;
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
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void testFindTotalUsersWith(){
        assertEquals(2L,(long) userService.findTotalUsersWithNoEditedReviews());
    }

    @Test
    public void testFindByUsernameConsistsOfTextAndHasAtLeastOneReview(){
        List<User> actualUsers = userService.findByUsernameConsistsOfTextAndHasAtLeastOneReview();
        List<User> expectedUsers = new ArrayList<>();

        assertEquals(2,actualUsers.size());

        expectedUsers.add(userService.findByUsername("Ark"));
        expectedUsers.add(userService.findByUsername("Frog"));

        actualUsers.sort(Comparator.comparingInt(User::getId));

        assertEquals(expectedUsers,actualUsers);
    }

    @Test
    public void testFindByUsernameMatchingToRegexp(){
        assertEquals(userService.findByUsername("Frog"), userService.findByUsernameMatchingToRegexp("[F]+").get(0));
    }
}
