package com.mini.mini_2.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.mini_2.food.domain.entity.FoodEntity;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Integer> {
    List<FoodEntity> findAllByRestAreaId(Integer RestAreaId);	
    
}
