package com.example.dao.daoApi;

import com.example.entity.Discount;
import java.util.List;

public interface DiscountDao extends CRUDDao {

    List<Discount> findAll();
}
