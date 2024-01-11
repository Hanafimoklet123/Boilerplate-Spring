package com.boilerplate.spring.repository;

import com.boilerplate.spring.entity.Roles;
import com.boilerplate.spring.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, String> {
    @Override
    Optional<Roles> findById(String s);

    Optional<Roles> findByName(String name);
}
