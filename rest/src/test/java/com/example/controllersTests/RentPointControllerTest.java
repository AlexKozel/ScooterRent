package com.example.controllersTests;

import com.example.controllers.RentPointController;
import com.example.dto.PageDTO;
import com.example.dto.RentPointDTO;
import com.example.service.RentPointService;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RentPointControllerTest implements CRUDTest {

    RentPointService service = mock(RentPointService.class);
    RentPointController controller = new RentPointController(service);
    RentPointDTO dto = new RentPointDTO();

    @Test
    public void findByIdTest(){
        when(service.getOne(1)).thenReturn(dto);
        assertEquals(HttpStatus.OK, controller.getRentPointById(1).getStatusCode());
    }

    @Test
    public void findAllTest(){
        when(service.getAll(1)).thenReturn(new PageDTO());
        assertEquals(HttpStatus.OK, controller.getAllRentPoints(1).getStatusCode());
        verify(service).getAll(1);
    }

    @Test
    @Override
    public void saveTest() {
        when(service.save(dto)).thenReturn(dto);
        assertEquals(HttpStatus.CREATED,  controller.saveRentPoint(dto).getStatusCode());
        verify(service).save(dto);

    }

    @Test
    @Override
    public void updateTest() {
        when(service.update(dto)).thenReturn(dto);
        assertEquals(HttpStatus.OK,  controller.updateRentPoint(dto).getStatusCode());
        verify(service).update(dto);
    }

    @Test
    @Override
    public void deleteTest() {
        assertEquals(HttpStatus.OK,  controller.deleteRentPointById(1).getStatusCode());
        verify(service).deleteById(1);
    }

}
