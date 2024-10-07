package com.example.Fms.service.impl;

import com.example.Fms.entity.model.User;
import com.example.Fms.entity.request.LoginRequest;
import com.example.Fms.entity.request.RegisterRequest;
import com.example.Fms.repository.UserRepository;
import com.example.Fms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(RegisterRequest registerRequest) {
        if (!userRepository.existsByPhoneNumber(registerRequest.getPhoneNumber())) {
            if (!userRepository.existsByUsername(registerRequest.getUsername())) {
                User user = new User();
                user.setEmail(registerRequest.getEmail());
                user.setRole(registerRequest.getRole());
                user.setUsername(registerRequest.getUsername());
                user.setPassword(registerRequest.getPassword());
                user.setPhoneNumber(registerRequest.getPhoneNumber());
                return userRepository.save(user);
            } else {
                // return when already phoneNumber exists.
                return new User();
            }
        } else {
            /// return when username already exists.
            return new User();
        }
    }

    @Override
    public boolean loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user != null) {
            String password = user.getPassword();
            return password.equals(loginRequest.getPassword());
        } else {
            return false;
        }

    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserProfile(String username) {
       User user = userRepository.findByUsername(username);
       if (user != null) {
           Integer id = user.getId();
           return userRepository.findById(id);
       } else {
           return Optional.empty();
       }

    }

    @Override
    public User findByPhoneNumber(String ownerPhone) {
        return userRepository.findByPhoneNumber(ownerPhone);
    }

    @Override
    public void deleteAllData() {
        userRepository.deleteAll();
    }

    @Override
    public Optional<User> findById(Integer customerId) {
        return userRepository.findById(customerId);
    }


}
