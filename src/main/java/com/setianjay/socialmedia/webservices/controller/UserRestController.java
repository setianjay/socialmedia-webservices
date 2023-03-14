package com.setianjay.socialmedia.webservices.controller;

import com.setianjay.socialmedia.webservices.domain.model.UserResponse;
import com.setianjay.socialmedia.webservices.domain.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Handle users api.
 *
 * /users -> get all users
 * /users/{id} -> get specific users by id
 */
@RestController
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public List<UserResponse> retrieveAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/api/users/{id}")
    public UserResponse retrieveSpecificUsers(@PathVariable(name = "id") Long id){
        return userService.findById(id);
    }
}