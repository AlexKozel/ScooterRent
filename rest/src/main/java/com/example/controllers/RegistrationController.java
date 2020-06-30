package com.example.controllers;

import com.example.dao.LoginDaoImpl;
import com.example.dto.LoginDataDto;
import com.example.entity.LoginData;
import com.example.service.LoginDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    LoginDataService service;

    @Autowired
    LoginDaoImpl dao;

//    @PostMapping("/registration")
//    public void registration(){
//
//    }

    @GetMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginData getLoginData(){
        LoginDataDto dataDto =  service.findLoginDataById(1);
        System.out.println(dataDto);
        return dao.findById(1);
    }

//    @GetMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
//    public LoginDataDto getLoginData(){
//        LoginDataDto dataDto =  service.findLoginDataById(1);
//        System.out.println(dataDto);
//      return dataDto;
//    }

}
