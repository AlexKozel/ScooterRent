package com.example.dto;

import lombok.Data;

@Data
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