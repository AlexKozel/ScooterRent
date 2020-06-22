package com.example.dao.daoApi;

import com.example.entity.LoginData;

import java.util.List;

public interface LoginDao extends CRUDDao {

    List<LoginData> findAll();

}