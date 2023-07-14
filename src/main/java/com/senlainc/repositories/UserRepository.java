package com.senlainc.repositories;

import com.senlainc.models.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    void saveOrUpdate(User user);

    User findById(int id);

    void delete(User user);

    void delete(int id);

    Long findTotalUsersWithNoEditedReviews();

    List<User> findByUsernameMatchingToRegexp(String regex);

    List<User> findByUsernameConsistsOfTextAndHasAtLeastOneReview();

    User findByUsername(String username);
}
