package com.example.kk.mapper;

import com.example.kk.dto.user.UserResponse;
import com.example.kk.entites.User;

import java.util.List;

public interface UserMapper {
    UserResponse toDto(User object);

    List<UserResponse> toDtos(List<User> users);
}
