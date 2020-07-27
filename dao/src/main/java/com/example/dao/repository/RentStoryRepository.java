package com.example.dao.repository;

import com.example.entity.RentStory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface RentStoryRepository extends CommonRepository<RentStory> {

   Page<RentStory> findAllByUserUserIdLike(int userId, Pageable pageable);
}
