package com.example.mapper;

import com.example.dto.DiscountDTO;
import com.example.entity.Discount;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DiscountMapper implements MapperAPI<Discount, DiscountDTO> {

    @Autowired
    private MainMapper modelMapper;
    private TypeMap<Discount, DiscountDTO> typeMap;

    @Override
    public DiscountDTO toDto(Discount discount) {
        if(typeMap == null){
        typeMap = modelMapper.createTypeMap(Discount.class, DiscountDTO.class);}
        typeMap.addMappings(mapping -> mapping.map(discount1 -> discount.getUser().getUserId(), DiscountDTO::setUserId));
        return Objects.isNull(discount) ? null : modelMapper.map(discount, DiscountDTO.class);
    }

    @Override
    public Discount toEntity(DiscountDTO discountDTO){
        return Objects.isNull(discountDTO) ? null : modelMapper.map(discountDTO, Discount.class);
    }
}
