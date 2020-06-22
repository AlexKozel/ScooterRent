package com.example.dao.daoApi;

import com.example.entity.Scooter;

import java.util.List;

public interface ScooterDao extends CRUDDao {

    List<Scooter> findAll();

}