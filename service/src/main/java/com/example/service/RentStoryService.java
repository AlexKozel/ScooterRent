package com.example.service;

import com.example.dao.repository.RentStoryRepository;
import com.example.dto.PageDTO;
import com.example.dto.RentStoryDTO;
import com.example.entity.RentStory;
import com.example.mapper.RentStoryMapper;
import com.example.serviceAPI.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class RentStoryService extends AbstractService<RentStory, RentStoryDTO, RentStoryRepository, RentStoryMapper> {

    public RentStoryService(RentStoryRepository repository, RentStoryMapper mapper) {
        super(repository, mapper);
    }

    public PageDTO findByUserId(int userId, int page) {
        Page<RentStory> ePage = repository.findAllByUserUserIdLike(userId, PageRequest.of(page, 10 ));

        PageDTO pageDTO = new PageDTO();
        pageDTO.setList(ePage.getContent().stream().map(mapper::toDto).collect(Collectors.toCollection(ArrayList::new)));
        pageDTO.setTotalPages(ePage.getTotalPages());
        return pageDTO;
    }
}
