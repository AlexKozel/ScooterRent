package com.example.service;

import com.example.dao.repository.LoginDataRepository;
import com.example.dto.LoginDataDto;
import com.example.entity.LoginData;
import com.example.mapper.LoginDataMapper;
import com.example.serviceAPI.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginDataService extends AbstractService<LoginData, LoginDataDto, LoginDataRepository, LoginDataMapper> {

    private final PasswordEncoder passwordEncoder;

    public LoginDataService(LoginDataRepository repository, LoginDataMapper mapper,@Autowired PasswordEncoder passwordEncoder ) {
        super(repository, mapper);
        this.passwordEncoder = passwordEncoder;
    }

    public LoginData findByLogin(String login) {
        return repository.findByLogin(login);
    }

    public LoginData findByLoginAndPassword(String login, String password) {
        LoginData loginData = findByLogin(login);
        if (loginData != null) {
            if (passwordEncoder.matches(password, loginData.getPassword())) {
                return loginData;
            }
        }
        return null;
    }
}