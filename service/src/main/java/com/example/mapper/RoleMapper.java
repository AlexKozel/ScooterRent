package com.example.mapper;

import com.example.dto.RoleDTO;
import com.example.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RoleMapper implements MapperAPI<Role, RoleDTO>{

    @Autowired
    private MainMapper modelMapper;

    public RoleDTO toDto(Role role) {
        return Objects.isNull(role) ? null : modelMapper.map(role, RoleDTO.class);
    }

    public Role toEntity(RoleDTO roleDTO){
        return Objects.isNull(roleDTO) ? null : modelMapper.map(roleDTO, Role.class);
    }


}
