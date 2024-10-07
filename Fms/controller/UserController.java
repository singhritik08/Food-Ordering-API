package com.example.Fms.controller;

import com.example.Fms.entity.model.User;
import com.example.Fms.entity.request.LoginRequest;
import com.example.Fms.entity.request.RegisterRequest;
import com.example.Fms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
public class UserController {



    /// i got a issue when multiple user created with same username(without any issue)


    @Autowired
    // Object of UserService.
    private UserService userService;

    // register a new user in Food Management System.
    @PostMapping("/save")
    public User saveUser(@RequestBody RegisterRequest registerRequest) {
        return userService.saveUser(registerRequest);
    }

    // return true only if login success
    @PostMapping("/login")
    public boolean loginUser(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }

    // provides you all user (customer and owner)
    @GetMapping("/all/user")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    // try it to another way where you can use response class.
    @GetMapping("/profile")
    public Optional<User> getUserProfile(@RequestParam String username){
        return userService.getUserProfile(username);
    }
    @DeleteMapping("/wipeAllData")
    public void deleteAllData() {
        userService.deleteAllData();
    }



}

