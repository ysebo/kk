package com.example.kk.mapper.impl;
import com.example.kk.dto.user.UserResponse;
import com.example.kk.entites.User;
import com.example.kk.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toDto(User object) {
        UserResponse userResponse = new UserResponse();
        userResponse.setAge(object.getAge());
        userResponse.setId(object.getId());
        userResponse.setName(object.getName());
        userResponse.setCourse(object.getCourse());
        userResponse.setUniversity(object.getUniversity());
        return userResponse;
    }
    @Override
    public List<UserResponse>toDtos(List<User> users){
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users){
            userResponses.add(toDto(user));
        }
        return userResponses;
    }

}
