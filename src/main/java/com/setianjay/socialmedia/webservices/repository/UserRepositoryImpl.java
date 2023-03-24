package com.setianjay.socialmedia.webservices.repository;

import com.setianjay.socialmedia.webservices.dao.UserDao;
import com.setianjay.socialmedia.webservices.model.entity.UserEntity;
import com.setianjay.socialmedia.webservices.model.request.UserRequest;
import com.setianjay.socialmedia.webservices.model.response.UserResponse;
import com.setianjay.socialmedia.webservices.domain.repository.UserRepository;
import com.setianjay.socialmedia.webservices.util.MappingUtil;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserDao userDao;

    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<UserResponse> findAll() {
        return userDao.findAll().stream().map(MappingUtil::userEntityToUserResponse).toList();
    }

    @Override
    public UserResponse findById(Long id) {
        Optional<UserEntity> user = userDao.findById(id);
        return user.map(MappingUtil::userEntityToUserResponse).orElse(null);

    }

    @Override
    public UserResponse save(UserRequest user) {
        UserEntity userEntity = MappingUtil.userRequestToUserEntity(user);
        return MappingUtil.userEntityToUserResponse(userDao.save(userEntity));
    }
}
