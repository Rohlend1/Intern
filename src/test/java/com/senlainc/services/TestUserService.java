package com.senlainc.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.senlainc.config.TestConfig;
import com.senlainc.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:dataset.xml")
@DbUnitConfiguration(databaseConnection = "dataSource")
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void testFindTotalUsersWith(){
        assertEquals(2L,(long) userService.findTotalUsersWithNoEditedReviews());
    }

    @Test
    public void testFindByUsernameConsistsOfTextAndHasAtLeastOneReview(){
        List<User> actualUsers = userService.findByUsernamePatternAndReviews();
        List<User> expectedUsers = new ArrayList<>();

        assertEquals(2,actualUsers.size());

        expectedUsers.add(userService.findByUsername("Ark"));
        expectedUsers.add(userService.findByUsername("Frog"));

        actualUsers.sort(Comparator.comparingInt(User::getId));

        assertEquals(expectedUsers,actualUsers);
    }

    @Test
    public void testFindByUsernameMatchingToRegexp(){
        assertEquals(userService.findByUsername("Frog"), userService.findByUsernamePattern("[F]+").get(0));
    }
}
