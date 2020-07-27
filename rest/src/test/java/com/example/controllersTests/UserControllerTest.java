package com.example.controllersTests;

import com.example.controllers.UserController;
import com.example.dto.PageDTO;
import com.example.dto.UserDTO;
import com.example.service.UserService;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest implements CRUDTest {

    UserService service = mock(UserService.class);
    UserController controller = new UserController(service);
    UserDTO dto = new UserDTO();

    @Test
    public void findByIdTest() {
        when(service.getOne(1)).thenReturn(dto);
        assertEquals(HttpStatus.OK, controller.getUserById(1).getStatusCode());
    }

    @Test
    public void findAllTest() {
        when(service.getAll(1)).thenReturn(new PageDTO());
        assertEquals(HttpStatus.OK, controller.getAllUsers(1).getStatusCode());
        verify(service).getAll(1);
    }

    @Test
    @Override
    public void saveTest() {
        when(service.save(dto)).thenReturn(dto);
        assertEquals(HttpStatus.CREATED, controller.saveUser(dto).getStatusCode());
        verify(service).save(dto);
    }

    @Test
    @Override
    public void updateTest() {
        when(service.update(dto)).thenReturn(dto);
        assertEquals(HttpStatus.CREATED, controller.updateUser(dto).getStatusCode());
        verify(service).update(dto);
    }

    @Test
    @Override
    public void deleteTest() {
        assertEquals(HttpStatus.OK, controller.deleteUserById(1).getStatusCode());
        verify(service).deleteById(1);
    }
}
