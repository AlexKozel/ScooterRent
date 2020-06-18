package com.example.service;

import com.example.dao.DiscountDaoImpl;
import com.example.dao.UserDaoImpl;
import com.example.model.AbstractEntity;
import com.example.model.User;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    DiscountDaoImpl discountDao = new DiscountDaoImpl();
    UserDaoImpl userDao = new UserDaoImpl();

    public String message(){

//        Discount d =  discountDao.findById(1);
        User u = userDao.findById(1);
        String s = ("Вот объект из базы данных" + u.toString() + "\n" + "Вот Все объкеты - " );
        return s;
    }

    public void save(AbstractEntity entity){
        discountDao.save(entity);
    }
}
