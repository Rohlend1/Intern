package com.senlainc.controllers;

import com.senlainc.dto.users.UserDTO;
import com.senlainc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<UserDTO> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.delete(id);
    }

    @PatchMapping
    public void updateUser(@RequestBody UserDTO reviewDTO){
        userService.saveOrUpdate(reviewDTO);
    }

    @PostMapping
    public void createUser(@RequestBody UserDTO reviewDTO){
        userService.saveOrUpdate(reviewDTO);
    }

    @GetMapping("/regexp")
    public List<UserDTO> getUserByUsernameRegexp(@RequestParam("regexp") String regexp){
        return userService.findByUsernameMatchingToRegexp(regexp);
    }

    @GetMapping("/no_edited_reviews")
    public Long getUserByTotalUsersWithNoEditedReviews(){
        return userService.findTotalUsersWithNoEditedReviews();
    }

    @GetMapping("/consists_of_text_and_review")
    public List<UserDTO> getUserByUsernameConsistsOfTextAndHasAtLeastOneReview(){
        return userService.findByUsernameConsistsOfTextAndHasAtLeastOneReview();
    }
}
