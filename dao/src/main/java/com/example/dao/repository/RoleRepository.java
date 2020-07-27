package com.example.dao.repository;

import com.example.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CommonRepository<Role> {

    Role findByName(String name);
}
