package com.example.service;

import com.example.dao.repository.LoginDataRepository;
import com.example.dto.LoginDataDto;
import com.example.entity.LoginData;
import com.example.mapper.LoginDataMapper;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LoginDataTest implements CRUDTest{

    LoginDataMapper loginDataMapper = mock(LoginDataMapper.class);
    LoginDataRepository repository = mock(LoginDataRepository.class);
    PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);

    LoginData loginData = new LoginData("name", "password");
    LoginDataDto loginDataDto = new LoginDataDto();

    LoginDataService service;

    @Test
    public void findByIdTest() {
        LoginDataService service = getService();
        when(loginDataMapper.toDto(any())).thenReturn(loginDataDto);
        when(repository.findById(1)).thenReturn(java.util.Optional.ofNullable(loginData));
        LoginDataDto loginDataDto = service.getOne(1);
        assertEquals(loginDataDto, this.loginDataDto);
        verify(repository).findById(1);
    }

    @Test
    @Override
    public void findAllTest() {
        LoginDataService service = getService();
        List<LoginData> loginDataList = new ArrayList<>();
        loginDataList.add(loginData);
        Page page = new PageImpl(loginDataList);
        when(loginDataMapper.toDto(any())).thenReturn(loginDataDto);
        when(repository.findAll(PageRequest.of(1, 10))).thenReturn(page);
        service.getAll(1);
        verify(repository).findAll(PageRequest.of(1, 10));
    }

    @Test
    @Override
    public void saveTest() {
        LoginDataService service = getService();
        when(loginDataMapper.toEntity(any())).thenReturn(loginData);
        service.save(loginDataDto);
        verify(repository).save(any());
    }


    @Test
    @Override
    public void updateTest() {
        LoginDataService service = getService();
        when(repository.existsById(0)).thenReturn(true);
        when(loginDataMapper.toEntity(any())).thenReturn(loginData);
        service.update(loginDataDto);
        verify(repository).save(any());
    }

    @Test
    @Override
    public void deleteTest() {
        LoginDataService service = getService();
        when(repository.existsById(1)).thenReturn(true);
        service.deleteById(1);
        verify(repository).deleteById(1);
    }

    @PostConstruct
    public LoginDataService getService(){
        if  (service == null){
            service = new LoginDataService(repository, loginDataMapper, passwordEncoder );
        }
        return service;
    }
}
