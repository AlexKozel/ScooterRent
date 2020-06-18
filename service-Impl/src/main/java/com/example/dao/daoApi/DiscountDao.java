package com.example.dao.daoApi;

import com.example.model.Discount;
import java.util.List;

public interface DiscountDao extends CRUDDao {

    List<Discount> findAll();
}
