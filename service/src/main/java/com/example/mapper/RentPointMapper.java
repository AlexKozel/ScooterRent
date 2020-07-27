package com.example.mapper;

import com.example.dto.RentPointDTO;
import com.example.entity.RentPoint;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RentPointMapper implements MapperAPI<RentPoint, RentPointDTO> {

    @Autowired
    private MainMapper modelMapper;

    private TypeMap<RentPoint, RentPointDTO> toDTOTypeMap;

    public RentPointDTO toDto(RentPoint rentPoint) {
        if(toDTOTypeMap == null){
            toDTOTypeMap = modelMapper.createTypeMap(RentPoint.class, RentPointDTO.class);}
        toDTOTypeMap.addMappings(mapping -> mapping.map(singleRentPoint -> rentPoint.getCity().getCityId(), RentPointDTO::setCityId));
        return Objects.isNull(rentPoint) ? null : modelMapper.map(rentPoint, RentPointDTO.class);
    }

    public RentPoint toEntity(RentPointDTO rentPointDTO){
        return Objects.isNull(rentPointDTO) ? null : modelMapper.map(rentPointDTO, RentPoint.class);
    }

}
