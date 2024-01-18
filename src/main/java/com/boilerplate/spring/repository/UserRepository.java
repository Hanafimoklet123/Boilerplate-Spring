package com.boilerplate.spring.repository;

import com.boilerplate.spring.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, String> {
//    Users findByUsernameOrEmail(String username, String email);
    Optional<Users> findByEmail(String email);
}
