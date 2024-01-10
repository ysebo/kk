package com.example.kk.controller;


import com.example.kk.dto.user.UserRequest;
import com.example.kk.repositories.UserRepository;
import com.example.kk.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MainController {

    private final UserRepository userRepository;
    private final UserService userService;



    @PostMapping("register")
    public void register(@RequestBody UserRequest userRequest){
        userService.register(userRequest);
    }
    @GetMapping
    public String hello(){
        return "Hello World";
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ){
        userService.deleteById(id);

    }
    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id ,@RequestBody UserRequest userRequest){
        userService.updateById(id, userRequest);
    }


}