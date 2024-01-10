package com.example.kk.service.user.impl;

import com.example.kk.dto.user.UserRequest;
import com.example.kk.dto.user.UserResponse;
import com.example.kk.entites.User;
import com.example.kk.exception.NotFoundException;
import com.example.kk.repositories.UserRepository;
import com.example.kk.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public String findAll(String name) {
        User user = new User();
        user.setName(name);

        userRepository.save(user);
        return name+" registered!";
    }

    @Override
    public UserResponse getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            System.out.println("user is empty!");
        }
        else {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(user.get().getId());
            userResponse.setAge(user.get().getAge());
            userResponse.setName(user.get().getName());
            return userResponse;

        }
        return null;
    }

    @Override
    public void  deleteById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            System.out.println("user is empty!");
        }
        else {
            userRepository.deleteById(id);
        }

    }

    @Override
    public void updateById(Long id, UserRequest userRequest) {


        Optional<User> user = userRepository.findById(id);
        if
        (user.isEmpty()){
            System.out.println("user is empty!");
        }
        else {

            user.get().setName(userRequest.getName());
            user.get().setAge(userRequest.getAge());
            user.get().setCourse(userRequest.getCourse());
            user.get().setUniversity(userRequest.getUniversity());
            userRepository.save(user.get());

        }
    }



    @Override
    public void register(UserRequest userRequest) {
        if (userRequest.getName().contains("@"))
            throw new NotFoundException("NOT FOUND" , HttpStatus.BAD_GATEWAY);
        User user = new User();
        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());
        user.setCourse(userRequest.getCourse());

        userRepository.save(user);
    }
}
