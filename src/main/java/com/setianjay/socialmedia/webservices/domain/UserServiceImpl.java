package com.setianjay.socialmedia.webservices.domain;

import com.setianjay.socialmedia.webservices.domain.service.UserService;
import com.setianjay.socialmedia.webservices.domain.model.UserResponse;
import com.setianjay.socialmedia.webservices.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse deleteById(Long id) {
        return userRepository.deleteById(id);
    }

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserResponse save(UserResponse user) {
        return userRepository.save(user);
    }
}
