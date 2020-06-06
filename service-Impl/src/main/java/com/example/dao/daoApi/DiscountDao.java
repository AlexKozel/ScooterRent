package com.example.dao.daoApi;

import com.example.model.Discount;
import java.util.ArrayList;

public interface DiscountDao extends CRUDDao {

    ArrayList<Discount> findAll();
}
