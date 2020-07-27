package com.example.service;

import com.example.dao.repository.UserRepository;
import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.serviceAPI.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, UserDTO, UserRepository, UserMapper> {

    public UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }

}