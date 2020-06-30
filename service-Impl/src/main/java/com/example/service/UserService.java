package com.example.service;

import com.example.dao.UserDaoImpl;
import com.example.dto.UserDTO;
import com.example.entity.AbstractEntity;
import com.example.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ModelMapper modelMapper;
    private final UserDaoImpl userDao;

    @Autowired
    UserService(ModelMapper modelMapper, UserDaoImpl userDao) {
        this.modelMapper = modelMapper;
        this.userDao = userDao;
    }

    public String message() {

//        Discount d =  discountDao.findById(1);
        User u = userDao.findById(1);
        UserDTO dto = modelMapper.map(u, UserDTO.class);
        System.out.println(modelMapper.getConfiguration().getFieldAccessLevel());
        return ("Вот объект из базы данных" + u.toString() + "\n" + "Вот Все объкеты - " + dto.toString());
    }

    public UserDTO getUser(){
        User u = userDao.findById(1);
        UserDTO dto = modelMapper.map(u, UserDTO.class);
        System.out.println(dto.toString());
        return dto;
    }

    public void save(AbstractEntity entity) {
        userDao.save(entity);
    }
}