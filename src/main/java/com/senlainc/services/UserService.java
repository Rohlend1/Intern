package com.senlainc.services;

import com.senlainc.models.User;
import com.senlainc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(int id){
        return userRepository.findById(id);
    }

    public void save(User user){
        if(user.getId() != null){
            update(user.getId(),user);
        }
        else {
            userRepository.save(user);
        }
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public void update(int id, User user){
        user.setId(id);
        userRepository.update(user);
    }

    public Long findTotalUsersWithNoEditedReviews(){
        return userRepository.findTotalUsersWithNoEditedReviews();
    }

    public List<User> findByUsernameMatchingToRegexp(String regex){
        return userRepository.findByUsernameMatchingToRegexp(regex);
    }

    public List<User> findByUsernameConsistsOfTextAndHasAtLeastOneReview(){
        return userRepository.findByUsernameConsistsOfTextAndHasAtLeastOneReview();
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
