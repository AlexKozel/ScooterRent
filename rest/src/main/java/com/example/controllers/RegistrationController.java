package com.example.controllers;

import com.example.dto.LoginDataDto;
import com.example.entity.LoginData;
import com.example.security.JwtProvider;
import com.example.service.LoginDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private LoginDataService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody LoginDataDto loginDataDto) {
        userService.save(loginDataDto);
        return "OK";
    }

    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody LoginDataDto request) {
        LoginData loginData = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(loginData.getLogin());
        return new ResponseEntity(token, HttpStatus.OK);
    }
}
