package com.setianjay.socialmedia.webservices.util;

import com.setianjay.socialmedia.webservices.model.entity.UserEntity;
import com.setianjay.socialmedia.webservices.model.request.UserRequest;
import com.setianjay.socialmedia.webservices.model.response.UserResponse;

import java.util.List;

public class MappingUtil {

    public static UserResponse userEntityToUserResponse(UserEntity userEntity) {
        return new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getBirthDate());
    }

    public static List<UserResponse> listUserEntityToListUserResponse(List<UserEntity> usersEntity) {
        return usersEntity.stream().map(userEntity ->
                new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getBirthDate())).toList();
    }

    public static UserEntity userRequestToUserEntity(UserRequest userRequest) {
        return new UserEntity(0L, userRequest.name(), userRequest.birthDate());
    }

}
