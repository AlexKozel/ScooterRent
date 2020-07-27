package com.example.controllersTests;

import com.example.controllers.SeasonTicketController;
import com.example.dto.PageDTO;
import com.example.dto.SeasonTicketDTO;
import com.example.service.SeasonTicketService;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SeasonTicketControllerTest implements CRUDTest {

    SeasonTicketService service = mock(SeasonTicketService.class);
    SeasonTicketController controller = new SeasonTicketController(service);
    SeasonTicketDTO dto = new SeasonTicketDTO();

    @Test
    public void findByIdTest() {
        when(service.getOne(1)).thenReturn(dto);
        assertEquals(HttpStatus.OK, controller.getSeasonTicketById(1).getStatusCode());
    }

    @Test
    public void findAllTest() {
        when(service.getAll(1)).thenReturn(new PageDTO());
        assertEquals(HttpStatus.OK, controller.getAllSeasonTickets(1).getStatusCode());
        verify(service).getAll(1);
    }

    @Test
    @Override
    public void saveTest() {
        when(service.save(dto)).thenReturn(dto);
        assertEquals(HttpStatus.CREATED, controller.saveSeasonTicket(dto).getStatusCode());
        verify(service).save(dto);

    }

    @Test
    @Override
    public void updateTest() {
        when(service.update(dto)).thenReturn(dto);
        assertEquals(HttpStatus.OK, controller.updateSeasonTicket(dto).getStatusCode());
        verify(service).update(dto);
    }

    @Test
    @Override
    public void deleteTest() {
        assertEquals(HttpStatus.OK, controller.deleteSeasonTicketById(1).getStatusCode());
        verify(service).deleteById(1);
    }

}
