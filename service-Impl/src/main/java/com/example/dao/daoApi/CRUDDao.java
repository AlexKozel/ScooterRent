package com.example.dao.daoApi;

import com.example.entity.AbstractEntity;

public interface CRUDDao {
    public AbstractEntity findById(int id);
    public void deleteById(int id);
    public void update(AbstractEntity entity);
    public void save(AbstractEntity entity);
}
