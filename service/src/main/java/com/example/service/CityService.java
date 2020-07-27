package com.example.service;

import com.example.dao.repository.CityRepository;
import com.example.dto.CityDTO;
import com.example.entity.City;
import com.example.mapper.CityMapper;
import com.example.serviceAPI.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class CityService extends AbstractService<City, CityDTO, CityRepository, CityMapper> {

    public CityService(CityRepository repository, CityMapper mapper) {
        super(repository, mapper);
    }

}