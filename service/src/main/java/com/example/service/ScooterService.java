package com.example.service;

import com.example.dao.repository.ScooterRepository;
import com.example.dto.ScooterDTO;
import com.example.entity.Scooter;
import com.example.mapper.ScooterMapper;
import com.example.serviceAPI.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ScooterService extends AbstractService<Scooter, ScooterDTO, ScooterRepository, ScooterMapper> {

    public ScooterService(ScooterRepository repository, ScooterMapper mapper) {
        super(repository, mapper);
    }

}