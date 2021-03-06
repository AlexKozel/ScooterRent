package com.example.serviceAPI;

import com.example.dto.PageDTO;

public interface CommonService<D> {

    D getOne(Integer id);

    PageDTO getAll(int page);

    D save(D dto) throws Exception;

    D update(D dto);

    void deleteById(Integer id);


}
