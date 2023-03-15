package com.setianjay.socialmedia.webservices.controller;

import com.setianjay.socialmedia.webservices.constant.Constant;
import com.setianjay.socialmedia.webservices.domain.model.UserResponse;
import com.setianjay.socialmedia.webservices.domain.service.UserService;
import com.setianjay.socialmedia.webservices.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<UserResponse> retrieveSpecificUsers(@PathVariable(name = "id") Long id){
        UserResponse response = userService.findById(id);
        if(response == null){
            throw new ResourceNotFoundException(Constant.ErrorMessage.USER_NOT_FOUND);
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id){
        Boolean isDeleted = userService.deleteById(id);
        if(!isDeleted){
            throw new ResourceNotFoundException(Constant.ErrorMessage.USER_NOT_FOUND);
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserResponse user){
        UserResponse userResponse = userService.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(userResponse);
    }
}
