package com.example.service;

import com.example.dao.repository.SeasonTicketRepository;
import com.example.dto.SeasonTicketDTO;
import com.example.entity.SeasonTicket;
import com.example.mapper.SeasonTicketMapper;
import com.example.serviceAPI.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class SeasonTicketService extends AbstractService<SeasonTicket, SeasonTicketDTO, SeasonTicketRepository, SeasonTicketMapper> {

    public SeasonTicketService(SeasonTicketRepository repository, SeasonTicketMapper mapper) {
        super(repository, mapper);
    }

}