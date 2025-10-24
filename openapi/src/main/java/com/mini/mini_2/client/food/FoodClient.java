package com.mini.mini_2.client.food;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mini.mini_2.client.food.domain.FoodRequestDTO;
import com.mini.mini_2.client.food.domain.FoodResponseDTO;



@FeignClient(
    name = "food-service", 
    url = "${GATEWAY_URL:http://service-food-1:8080}"
)
public interface FoodClient {
    // @GetMapping("/api/v1/mini/food/lists/food/{foodId}")
    // FoodResponseDTO findById(@PathVariable("foodId") Integer foodId);

    // @GetMapping("/api/v1/mini/food/lists")
    // List<FoodResponseDTO> findAll();

    @PostMapping("/api/v1/mini/food/create")
    FoodResponseDTO create(FoodRequestDTO foodRequestDTO);

}
