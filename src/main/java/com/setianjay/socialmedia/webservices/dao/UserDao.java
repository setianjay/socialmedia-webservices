package com.setianjay.socialmedia.webservices.dao;

import com.setianjay.socialmedia.webservices.dao.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserDao {

    private final static List<UserEntity> userList = new ArrayList<>();
    private static Long counterId = 0L;

    static {
        userList.add(new UserEntity(++counterId, "setyarto", LocalDate.of(1962, Month.JULY, 24)));
        userList.add(new UserEntity(++counterId, "sudaryati", LocalDate.of(1972, Month.OCTOBER, 16)));
        userList.add(new UserEntity(++counterId, "gurindo sekti", LocalDate.of(1997, Month.JUNE, 5)));
        userList.add(new UserEntity(++counterId, "hari setiaji", LocalDate.of(2000, Month.NOVEMBER, 11)));
    }


    public UserEntity deleteById(Long id){
        UserEntity deletedUser = findById(id);
        boolean hasDeleted = userList.removeIf(userEntity -> userEntity.getId().equals(id));
        if(!hasDeleted){
            return null;
        }
        return deletedUser;
    }

    public List<UserEntity> findAll(){
        return Collections.unmodifiableList(userList);
    }

    public UserEntity findById(Long id){
        return userList.stream().filter(users -> users.getId().equals(id)).findFirst().orElse(null);
    }

    public UserEntity save(UserEntity user){
        user.setId(++counterId);
        userList.add(user);
        return user;
    }
}
