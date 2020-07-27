package com.example.mapper;

import com.example.dto.CityDTO;
import com.example.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CityMapper implements MapperAPI<City, CityDTO> {

    @Autowired
    private MainMapper modelMapper;

    public CityDTO toDto(City city) {
        return Objects.isNull(city) ? null : modelMapper.map(city, CityDTO.class);
    }

    public City toEntity(CityDTO cityDTO){
        return Objects.isNull(cityDTO) ? null : modelMapper.map(cityDTO, City.class);
    }


}
