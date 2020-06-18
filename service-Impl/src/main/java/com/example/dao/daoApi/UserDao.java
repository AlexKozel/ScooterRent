package com.example.dao.daoApi;

import com.example.model.User;

import java.util.List;

public interface UserDao extends CRUDDao{

    List<User> findAll();

}
