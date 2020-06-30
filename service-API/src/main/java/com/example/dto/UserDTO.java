package com.example.dto;


public class UserDTO extends AbstractDTO{

    private Integer userId;

    private String firstName;

    private String secondName;

    @Override
    public String toString() {
        return "UserDTO{" +
                "Id='" + userId + '\'' +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';


    }
}