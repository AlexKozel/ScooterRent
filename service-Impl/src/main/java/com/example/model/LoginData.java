package com.example.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoginData {

    @NonNull
    private int LoginId;
    @NonNull
    private String Login;
    @NonNull
    private String Password;

}
