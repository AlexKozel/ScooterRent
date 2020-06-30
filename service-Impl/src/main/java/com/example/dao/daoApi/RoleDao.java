package com.example.dao.daoApi;

import com.example.entity.Role;

import java.util.List;

public interface RoleDao extends CRUDDao {

    List<Role> findAll();
}
