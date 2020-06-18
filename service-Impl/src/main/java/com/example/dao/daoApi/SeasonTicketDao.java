package com.example.dao.daoApi;

import com.example.model.SeasonTicket;

import java.util.List;

public interface SeasonTicketDao extends CRUDDao {

    List<SeasonTicket> findAll();

}