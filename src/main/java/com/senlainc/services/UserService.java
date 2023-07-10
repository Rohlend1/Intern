package com.senlainc.services;

import com.senlainc.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    void saveOrUpdate(User user);

    void delete(User user);

    Long findTotalUsersWithNoEditedReviews();

    List<User> findByUsernameMatchingToRegexp(String regex);

    List<User> findByUsernameConsistsOfTextAndHasAtLeastOneReview();
    User findByUsername(String username);
}
