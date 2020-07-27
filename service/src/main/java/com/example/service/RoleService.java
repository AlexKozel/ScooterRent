package com.example.service;

import com.example.dao.repository.RoleRepository;
import com.example.dto.RoleDTO;
import com.example.entity.Role;
import com.example.mapper.RoleMapper;
import com.example.serviceAPI.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractService<Role, RoleDTO, RoleRepository, RoleMapper> {

    public RoleService(RoleRepository repository, RoleMapper mapper) {
        super(repository, mapper);
    }

}