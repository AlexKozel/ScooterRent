package com.example.dao.daoApi;

import com.example.model.AbstractEntity;

import java.util.Set;

public interface CRUDDao {
    public AbstractEntity findById(int id);
    public void deleteById(int id);
    public void update(AbstractEntity entity, int id);
}
