package com.setianjay.socialmedia.webservices.dao;

import com.setianjay.socialmedia.webservices.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserDao extends JpaRepository<UserEntity, Long> {
}
