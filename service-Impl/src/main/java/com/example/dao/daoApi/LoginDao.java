package com.example.dao.daoApi;

import com.example.model.LoginData;

import java.util.List;

public interface LoginDao extends CRUDDao {

    List<LoginData> findAll();

}