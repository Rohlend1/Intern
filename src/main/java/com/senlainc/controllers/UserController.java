package com.senlainc.controllers;

import com.senlainc.dto.users.UserDTO;
import com.senlainc.errors.ModelNotFoundException;
import com.senlainc.models.User;
import com.senlainc.services.UserService;
import com.senlainc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private Converter converter;

    @GetMapping
    public List<UserDTO> getUsers(){
        return converter.convertListToUserDTO(userService.findAll());
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") int id){
        return converter.convertToUserDTO(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id){
        try{
            User review = userService.findById(id);
            userService.delete(review);
        }
        catch (ModelNotFoundException e){
            System.out.println("No genre with this id was found");
        }
    }

    @PatchMapping
    public void updateUser(UserDTO reviewDTO){
        userService.saveOrUpdate(converter.convertToUser(reviewDTO));
    }

    @PostMapping
    public void createUser(UserDTO reviewDTO){
        userService.saveOrUpdate(converter.convertToUser(reviewDTO));
    }

    @GetMapping("/regexp")
    public List<UserDTO> getUserByUsernameRegexp(@RequestParam("regexp") String regexp){
        return converter.convertListToUserDTO(userService.findByUsernameMatchingToRegexp(regexp));
    }

    @GetMapping("/no_edited_reviews")
    public Long getUserByTotalUsersWithNoEditedReviews(){
        return userService.findTotalUsersWithNoEditedReviews();
    }

    @GetMapping("/consists_of_text_and_review")
    public List<UserDTO> getUserByUsernameConsistsOfTextAndHasAtLeastOneReview(){
        return converter.convertListToUserDTO(userService.findByUsernameConsistsOfTextAndHasAtLeastOneReview());
    }
}
