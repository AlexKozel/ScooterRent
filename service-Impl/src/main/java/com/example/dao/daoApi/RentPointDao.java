package com.example.dao.daoApi;

import com.example.model.RentPoint;

import java.util.List;

public interface RentPointDao   extends CRUDDao {

    List<RentPoint> findAll();

}