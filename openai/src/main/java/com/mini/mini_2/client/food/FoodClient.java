package com.mini.mini_2.client.food;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mini.mini_2.client.food.domain.FoodRequestDTO;
import com.mini.mini_2.client.food.domain.FoodResponseDTO;

@FeignClient(
    name = "food-service"
    //url = "${GATEWAY_URL:http://service-restarea-unit-1:8080}"
)
public interface FoodClient {
    @PostMapping("/api/v1/mini/food/create")
    FoodResponseDTO create(FoodRequestDTO foodRequestDTO);

    @GetMapping("/api/v1/mini/food/search/signature/{restAreaId}")
    List<FoodResponseDTO> searchByRestAreaId(@PathVariable("restAreaId") Integer restAreaId);
}