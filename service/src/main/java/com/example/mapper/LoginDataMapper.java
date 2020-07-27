package com.example.mapper;

import com.example.dao.repository.RoleRepository;
import com.example.dto.LoginDataDto;
import com.example.entity.LoginData;
import com.example.entity.Role;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class LoginDataMapper implements MapperAPI<LoginData, LoginDataDto> {

    @Autowired
    private MainMapper modelMapper;
    @Autowired
    private RoleRepository repository;

    TypeMap<LoginData, LoginDataDto> toDTOTypeMap;

    public LoginDataDto toDto(LoginData loginData) {
        if (toDTOTypeMap == null) {
            toDTOTypeMap = modelMapper.createTypeMap(LoginData.class, LoginDataDto.class);
        }
        toDTOTypeMap.addMappings(mapping -> mapping.map(singleLogin -> loginData.getRoles(), LoginDataDto::setRoles));
        return Objects.isNull(loginData) ? null : modelMapper.map(loginData, LoginDataDto.class);
    }

    public LoginData toEntity(LoginDataDto loginDataDto) {
        LoginData loginData = Objects.isNull(loginDataDto) ? null : modelMapper.map(loginDataDto, LoginData.class);
        List<Role> roleList = new ArrayList<>();
        roleList.add(repository.getOne(2));
        // для создания по ролям на будущее

//        for (int roleId : loginDataDto.getRoles()
//        ) {
//            roleList.add(repository.getOne(roleId));
//        }
        loginData.setRoles(roleList);
        return loginData;
    }

}
