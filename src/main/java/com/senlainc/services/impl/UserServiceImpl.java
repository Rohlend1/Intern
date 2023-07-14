package com.senlainc.services.impl;

import com.senlainc.dto.users.UserDto;
import com.senlainc.repositories.UserRepository;
import com.senlainc.services.UserService;
import com.senlainc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final Converter converter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Converter converter) {
        this.userRepository = userRepository;
        this.converter = converter;
    }

    public List<UserDto> findAll(){
        return converter.convertListToUserDTO(userRepository.findAll());
    }

    public UserDto findById(int id){
        return converter.convertToUserDTO(userRepository.findById(id));
    }

    public void saveOrUpdate(UserDto userDTO){
        userRepository.saveOrUpdate(converter.convertToUser(userDTO));
    }

    public void delete(UserDto userDTO){
        userRepository.delete(converter.convertToUser(userDTO));
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    public Long findTotalUsersWithNoEditedReviews(){
        return userRepository.findTotalUsersWithNoEditedReviews();
    }

    public List<UserDto> findByUsernamePattern(String regex){
        return converter.convertListToUserDTO(userRepository.findByUsernameMatchingToRegexp(regex));
    }

    public List<UserDto> findByUsernamePatternAndReviews(){
        return converter.convertListToUserDTO(userRepository.findByUsernameConsistsOfTextAndHasAtLeastOneReview());
    }

    public UserDto findByUsername(String username){
        return converter.convertToUserDTO(userRepository.findByUsername(username));
    }
}
