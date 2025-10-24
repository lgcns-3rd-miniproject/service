package com.mini.mini_2.client.food;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mini.mini_2.client.food.domain.FoodRequestDTO;
import com.mini.mini_2.client.food.domain.FoodResponseDTO;



@FeignClient(
    name = "restarea-unit-service"
)
public interface FoodClient {
    
    @GetMapping("/api/v1/mini/food/lists")
    List<FoodResponseDTO> findAll();

    @PostMapping("/api/v1/mini/food/create")
    FoodResponseDTO create(FoodRequestDTO foodRequestDTO);

}
