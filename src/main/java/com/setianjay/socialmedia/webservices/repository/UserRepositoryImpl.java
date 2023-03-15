package com.setianjay.socialmedia.webservices.repository;

import com.setianjay.socialmedia.webservices.dao.UserDao;
import com.setianjay.socialmedia.webservices.model.entity.UserEntity;
import com.setianjay.socialmedia.webservices.model.response.UserResponse;
import com.setianjay.socialmedia.webservices.domain.repository.UserRepository;
import com.setianjay.socialmedia.webservices.util.MappingUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserDao userDao;

    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Boolean deleteById(Long id) {
        return userDao.deleteById(id);
    }

    @Override
    public List<UserResponse> findAll() {
        return MappingUtil.listUserEntityToListUserResponse(userDao.findAll());
    }

    @Override
    public UserResponse findById(Long id) {
        UserEntity user = userDao.findById(id);
        if (user == null) {
            return null;
        }

        return MappingUtil.userEntityToUserResponse(user);
    }

    @Override
    public UserResponse save(UserResponse user) {
        UserEntity userEntity = MappingUtil.userResponseToUserEntity(user);
        return MappingUtil.userEntityToUserResponse(userDao.save(userEntity));
    }
}
