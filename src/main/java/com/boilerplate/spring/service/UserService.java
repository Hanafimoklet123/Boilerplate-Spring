package com.boilerplate.spring.service;

import com.boilerplate.spring.entity.Users;
import com.boilerplate.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsernameOrEmail(username, username);

        if(user == null){
            throw new UsernameNotFoundException("User doesn't Exists By Username");
        }

        Set<GrantedAuthority> authorities = user.getRoles().stream().map((role -> new SimpleGrantedAuthority(role.getRoles()))).collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),authorities);
    }
}
