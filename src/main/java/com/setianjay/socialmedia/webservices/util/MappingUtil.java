package com.setianjay.socialmedia.webservices.util;

import com.setianjay.socialmedia.webservices.dao.entity.UserEntity;
import com.setianjay.socialmedia.webservices.domain.model.UserResponse;

import java.util.List;

public class MappingUtil {

    public static UserResponse userEntityToUserResponse(UserEntity userEntity) {
        return new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getBirthDate());
    }

    public static List<UserResponse> listUserEntityToListUserResponse(List<UserEntity> usersEntity) {
        return usersEntity.stream().map(userEntity ->
                new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getBirthDate())).toList();
    }

    public static UserEntity userResponseToUserEntity(UserResponse userResponse) {
        return new UserEntity(userResponse.getId(), userResponse.getName(), userResponse.getBirthDate());
    }

}
