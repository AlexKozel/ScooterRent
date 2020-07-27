package com.example.service;

import com.example.dao.repository.RentPointRepository;
import com.example.dto.RentPointDTO;
import com.example.entity.RentPoint;
import com.example.mapper.RentPointMapper;
import com.example.serviceAPI.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class RentPointService extends AbstractService<RentPoint, RentPointDTO, RentPointRepository, RentPointMapper> {

    public RentPointService(RentPointRepository repository, RentPointMapper mapper) {
        super(repository, mapper);
    }

}