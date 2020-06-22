package com.example.dao.daoApi;

import com.example.entity.City;


import java.util.List;

public interface CityDao extends CRUDDao {

    List<City> findAll();

}
