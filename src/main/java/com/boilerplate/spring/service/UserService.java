package com.boilerplate.spring.service;

import com.boilerplate.spring.dto.ChangePasswordRequest;
import com.boilerplate.spring.entity.Users;
import com.boilerplate.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;


@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void changePassword(ChangePasswordRequest request, Principal connectedUser){
        var user = (Users) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        //Check if the current password is correct
        if(!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())){
            throw new IllegalStateException("Wrong Password");
        }

        //Check if the two new passwords are the same
        if(!request.getNewPassword().equals(request.getConfirmationPassword())){
            throw new IllegalStateException("Password are not the same");
        }

        //Update the Password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        //Save to new Password
        userRepository.save(user);

    }
}
