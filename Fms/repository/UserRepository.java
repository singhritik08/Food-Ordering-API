package com.example.Fms.repository;

import com.example.Fms.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByPhoneNumber(String phoneNumber);
    User findByPhoneNumber(String phoneNumber);




}
