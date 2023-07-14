package com.senlainc.controllers;

import com.senlainc.dto.users.UserDto;
import com.senlainc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public List<UserDto> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.delete(id);
    }

    @PutMapping
    public void saveOrUpdateUser(@RequestBody UserDto reviewDTO){
        userService.saveOrUpdate(reviewDTO);
    }

    @GetMapping("/find/name/pattern")
    public List<UserDto> getUserByUsernamePattern(@RequestParam("regexp") String regexp){
        return userService.findByUsernamePattern(regexp);
    }

    @GetMapping("/find/review/not/edit")
    public Long getUserCountNotEditedReviews(){
        return userService.findTotalUsersWithNoEditedReviews();
    }

    @GetMapping("/find/name/pattern/review")
    public List<UserDto> getByUsernamePatternAndReviews(){
        return userService.findByUsernamePatternAndReviews();
    }
}
