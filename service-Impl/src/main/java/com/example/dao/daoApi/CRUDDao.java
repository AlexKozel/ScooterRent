package com.example.dao.daoApi;

import com.example.entity.AbstractEntity;

public interface CRUDDao {
    AbstractEntity findById(int id);
    void deleteById(int id);
    void update(AbstractEntity entity);
    void save(AbstractEntity entity);
}
