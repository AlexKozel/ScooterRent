package com.example.service;

import com.example.dao.repository.DiscountRepository;
import com.example.dto.DiscountDTO;
import com.example.entity.Discount;
import com.example.mapper.DiscountMapper;
import com.example.serviceAPI.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class DiscountService extends AbstractService<Discount, DiscountDTO, DiscountRepository, DiscountMapper> {

    public DiscountService(DiscountRepository repository, DiscountMapper mapper) {
        super(repository, mapper);
    }

}