package com.example.mapper;

import com.example.dto.UserDTO;
import com.example.entity.User;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserMapper implements MapperAPI<User, UserDTO>{

    @Autowired
    private MainMapper modelMapper;

    private TypeMap<User, UserDTO> toDTOTypeMap;

    public UserDTO toDto(User user) {
        if (toDTOTypeMap == null) {
            toDTOTypeMap = modelMapper.createTypeMap(User.class, UserDTO.class);
        }
        toDTOTypeMap.addMappings(mapping -> mapping.map(singleSeasonTicket -> user.getDiscount().getDiscountId(), UserDTO::setDiscountId));
        toDTOTypeMap.addMappings(mapping -> mapping.map(singleSeasonTicket -> user.getLoginData().getLoginId(), UserDTO::setLoginDataId));
        return Objects.isNull(user) ? null : modelMapper.map(user, UserDTO.class);
    }

    public User toEntity(UserDTO userDTO) {
        return Objects.isNull(userDTO) ? null : modelMapper.map(userDTO, User.class);
    }
}