package com.boilerplate.spring.controller;

import com.boilerplate.spring.dto.ChangePasswordRequest;
import com.boilerplate.spring.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService service;
    @PatchMapping
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest request, Principal connectedUser){
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

}
