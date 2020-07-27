package com.example.serviceAPI;

import com.example.dao.repository.CommonRepository;
import com.example.dto.AbstractDTO;
import com.example.dto.PageDTO;
import com.example.entity.AbstractEntity;
import com.example.exceptions.NotFoundException;
import com.example.mapper.MapperAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Transactional
public abstract class AbstractService<E extends AbstractEntity, D extends AbstractDTO, R extends CommonRepository<E>, M extends MapperAPI<E, D>>
        implements CommonService<D> {

    private final Logger logger = LoggerFactory.getLogger(AbstractService.class);

    protected final M mapper;
    protected final R repository;

    @Autowired
    public AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public D save(D dto) {
        logger.debug("save {}", dto);
        E entity = mapper.toEntity(dto);
        if (repository.existsById(dto.getDtoId())) {
            throw new RuntimeException("entity " + entity + " already exists");
        } else {
        repository.save(entity);}
        return dto;
    }

    @Override
    public D getOne(Integer id) {
        logger.debug("get entity with id {}",  id);
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public PageDTO getAll(int page) {
        logger.debug("get all entities on page  {}", page );
        Page<E> ePage = repository.findAll(PageRequest.of(page, 10));
        PageDTO pageDTO = new PageDTO();
        pageDTO.setList(ePage.getContent().stream().map(mapper::toDto).collect(Collectors.toCollection(ArrayList::new)));
        pageDTO.setTotalPages(ePage.getTotalPages());
        return pageDTO;
    }

    @Override
    public D update(D dto) {
        logger.debug("update {}", dto );
        E entity = mapper.toEntity(dto);
        if (repository.existsById(dto.getDtoId())) {
            repository.save(entity);
        } else throw new NotFoundException(entity.getClass().getSimpleName(), dto.getDtoId());
        return dto;
    }

    @Override
    public void deleteById(Integer id) {
        logger.debug("delete entity by id {}", id );
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else throw new NotFoundException("", id);
    }
}