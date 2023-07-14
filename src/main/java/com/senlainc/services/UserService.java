package com.senlainc.services;

import com.senlainc.dto.users.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(int id);

    void saveOrUpdate(UserDto user);

    void delete(UserDto user);

    void delete(int id);

    Long findTotalUsersWithNoEditedReviews();

    List<UserDto> findByUsernamePattern(String regex);

    List<UserDto> findByUsernamePatternAndReviews();
    UserDto findByUsername(String username);
}
