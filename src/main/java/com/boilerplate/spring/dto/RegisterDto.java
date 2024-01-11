package com.boilerplate.spring.dto;

import javax.validation.constraints.NotEmpty;

public class RegisterDto {
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String noHp;
    @NotEmpty(message = "Email should not be empty")
    private  String email;
    @NotEmpty(message = "Password should not be empty")
    private  String password;

    public RegisterDto(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNoHp() {
        return noHp;
    }
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
