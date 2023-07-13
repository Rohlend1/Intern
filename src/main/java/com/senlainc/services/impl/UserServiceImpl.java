package com.senlainc.services.impl;

import com.senlainc.dto.users.UserDTO;
import com.senlainc.models.User;
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

    public List<UserDTO> findAll(){
        return converter.convertListToUserDTO(userRepository.findAll());
    }

    public UserDTO findById(int id){
        return converter.convertToUserDTO(userRepository.findById(id));
    }

    public void saveOrUpdate(UserDTO userDTO){
        userRepository.saveOrUpdate(converter.convertToUser(userDTO));
    }

    public void delete(UserDTO userDTO){
        userRepository.delete(converter.convertToUser(userDTO));
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    public Long findTotalUsersWithNoEditedReviews(){
        return userRepository.findTotalUsersWithNoEditedReviews();
    }

    public List<UserDTO> findByUsernameMatchingToRegexp(String regex){
        return converter.convertListToUserDTO(userRepository.findByUsernameMatchingToRegexp(regex));
    }

    public List<UserDTO> findByUsernameConsistsOfTextAndHasAtLeastOneReview(){
        return converter.convertListToUserDTO(userRepository.findByUsernameConsistsOfTextAndHasAtLeastOneReview());
    }

    public UserDTO findByUsername(String username){
        return converter.convertToUserDTO(userRepository.findByUsername(username));
    }
}
