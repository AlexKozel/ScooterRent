package com.example.dto;

public class UserDTO {

    private String firstName;

    private String secondName;

    private Boolean role;

    @Override
    public String toString() {
        return "UserDTO{" +
                "FirstName='" + firstName + '\'' +
                ", SecondName='" + secondName + '\'' +
                ", Role='" + role + '\'' +
                '}';
    }
}