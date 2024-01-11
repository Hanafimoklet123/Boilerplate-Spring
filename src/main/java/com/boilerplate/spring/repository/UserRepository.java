package com.boilerplate.spring.repository;

import com.boilerplate.spring.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {
    Users findByUsernameOrEmail(String username, String email);
}