package com.setianjay.socialmedia.webservices.domain.repository;

import com.setianjay.socialmedia.webservices.domain.model.UserResponse;

import java.util.List;

public interface UserRepository {
    Boolean deleteById(Long id);

    List<UserResponse> findAll();

    UserResponse findById(Long id);

    UserResponse save(UserResponse user);
}
