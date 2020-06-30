package com.example.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginDataDto {

    private Integer loginId;
    private String login;
    private String password;

    @Override
    public String toString() {
        return "LoginDataDto{" +
                "loginId=" + loginId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
