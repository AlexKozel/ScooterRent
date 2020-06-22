package com.example.dao.daoApi;

import com.example.entity.User;

import java.util.List;

public interface UserDao extends CRUDDao{

    List<User> findAll();

}
