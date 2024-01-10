package com.example.kk.service.user;

import com.example.kk.dto.user.UserRequest;
import com.example.kk.dto.user.UserResponse;

public interface UserService {
    String findAll(String name);

    UserResponse getById(Long id);
    void deleteById(Long id);
    void updateById(Long id, UserRequest userRequest);




    void register(UserRequest userRequest);
}