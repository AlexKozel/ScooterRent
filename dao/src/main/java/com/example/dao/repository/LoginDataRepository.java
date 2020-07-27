package com.example.dao.repository;

import com.example.entity.LoginData;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDataRepository extends CommonRepository<LoginData> {

    LoginData findByLogin(String login);

}
