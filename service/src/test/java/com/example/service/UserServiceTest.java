package com.example.service;

import com.example.dao.repository.UserRepository;
import com.example.dto.UserDTO;
import com.example.entity.*;
import com.example.mapper.UserMapper;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest implements CRUDTest {

    UserMapper userMapper = mock(UserMapper.class);
    UserRepository userRepository = mock(UserRepository.class);

    User user = new User();
    UserDTO userDTO = new UserDTO();

    UserService service;

    @Test
    public void findByIdTest() {
        UserService service = getService();
        when(userMapper.toDto(any())).thenReturn(userDTO);
        when(userRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(user));
        UserDTO userDTO = service.getOne(1);
        assertEquals(userDTO, this.userDTO);
        verify(userRepository).findById(1);
    }

    @Test
    @Override
    public void findAllTest() {
        UserService service = getService();
        List<User> users = new ArrayList<>();
        users.add(user);
        Page page = new PageImpl(users);
        when(userMapper.toDto(any())).thenReturn(userDTO);
        when(userRepository.findAll(PageRequest.of(1, 10))).thenReturn(page);
        service.getAll(1);
        verify(userRepository).findAll(PageRequest.of(1, 10));
    }

    @Test
    @Override
    public void saveTest() {
        UserService service = getService();
        userDTO.setDiscountId(1);
        userDTO.setLoginDataId(1);
        when(userMapper.toEntity(any())).thenReturn(user);
        service.save(userDTO);
        verify(userRepository).save(any());
    }

    @Test
    @Override
    public void updateTest() {
        UserService service = getService();
        userDTO.setDiscountId(1);
        userDTO.setLoginDataId(1);
        when(userRepository.existsById(0)).thenReturn(true);
        when(userMapper.toEntity(any())).thenReturn(user);
        service.update(userDTO);
        verify(userRepository).save(any());
    }

    @Test
    @Override
    public void deleteTest() {
        UserService service = getService();
        when(userRepository.existsById(1)).thenReturn(true);
        service.deleteById(1);
        verify(userRepository).deleteById(1);
    }

    @PostConstruct
    public UserService getService() {
        if (service == null) {
            service = new UserService(userRepository, userMapper);
        }
        return service;
    }
}
