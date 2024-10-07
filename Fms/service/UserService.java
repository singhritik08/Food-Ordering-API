package com.example.Fms.service;

import com.example.Fms.entity.model.User;
import com.example.Fms.entity.request.LoginRequest;
import com.example.Fms.entity.request.RegisterRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(RegisterRequest registerRequest);

    boolean loginUser(LoginRequest loginRequest);

    List<User> findAllUsers();

    Optional<User> getUserProfile(String username);

    User findByPhoneNumber(String ownerPhone);

    void deleteAllData();

    Optional<User> findById(Integer customerId);
}
