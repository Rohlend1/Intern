package com.senlainc.services;

import com.senlainc.dto.users.UserDTO;
import com.senlainc.models.User;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();

    UserDTO findById(int id);

    void saveOrUpdate(UserDTO user);

    void delete(UserDTO user);

    void delete(int id);

    Long findTotalUsersWithNoEditedReviews();

    List<UserDTO> findByUsernameMatchingToRegexp(String regex);

    List<UserDTO> findByUsernameConsistsOfTextAndHasAtLeastOneReview();
    UserDTO findByUsername(String username);
}
