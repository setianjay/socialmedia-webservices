package com.setianjay.socialmedia.webservices.domain.repository;

import com.setianjay.socialmedia.webservices.model.request.UserRequest;
import com.setianjay.socialmedia.webservices.model.response.UserResponse;

import java.util.List;

public interface UserRepository {
    void deleteById(Long id);

    List<UserResponse> findAll();

    UserResponse findById(Long id);

    UserResponse save(UserRequest user);
}
