package com.setianjay.socialmedia.webservices.domain.service;

import com.setianjay.socialmedia.webservices.model.response.UserResponse;

import java.util.List;

public interface UserService {
    Boolean deleteById(Long id);

    List<UserResponse> findAll();

    UserResponse findById(Long id);

    UserResponse save(UserResponse user);
}
