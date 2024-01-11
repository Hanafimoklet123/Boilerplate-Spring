package com.boilerplate.spring.controller;

import com.boilerplate.spring.dto.LoginDto;
import com.boilerplate.spring.dto.RegisterDto;
import com.boilerplate.spring.entity.Roles;
import com.boilerplate.spring.entity.Users;
import com.boilerplate.spring.repository.RolesRepository;
import com.boilerplate.spring.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public ResponseEntity<String> AuthenticationUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User Login Successfully...", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> RegisterUser(@RequestBody RegisterDto registerDto){
        //Checking username exist in database
//        if(userRepository.existsByUserName(registerDto.getUsername())){
//            return new ResponseEntity<>("Username is already exist!", HttpStatus.BAD_REQUEST);
//        }
//
//        if (userRepository.existsByEmail(registerDto.getEmail())){
//            return new ResponseEntity<>("Email is already exist!", HttpStatus.BAD_REQUEST);
//        }

        Users user = new Users();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setNoHp(registerDto.getNoHp());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Roles roles = new Roles();
        rolesRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singletonList(roles));
        userRepository.save(user);

        return new ResponseEntity<>("User is Registered Successfully!", HttpStatus.OK);
    }

}
