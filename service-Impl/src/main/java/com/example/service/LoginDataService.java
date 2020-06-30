package com.example.service;

import com.example.dao.LoginDaoImpl;
import com.example.dao.UserDaoImpl;
import com.example.dao.daoApi.LoginDao;
import com.example.dto.LoginDataDto;
import com.example.entity.LoginData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginDataService {

    private final ModelMapper modelMapper;
    private final LoginDaoImpl dao;

    @Autowired
    public LoginDataService(ModelMapper modelMapper, LoginDaoImpl dao) {
        this.modelMapper = modelMapper;
        this.dao = dao;
    }

    public LoginDataDto findLoginDataById(int id){
        LoginData loginData = dao.findById(id);
        return modelMapper.map(loginData, LoginDataDto.class);
    }

    public void save(LoginDataDto loginDataDto){

        LoginData loginData = modelMapper.map(loginDataDto, LoginData.class);
        dao.save(loginData);
    }



}
