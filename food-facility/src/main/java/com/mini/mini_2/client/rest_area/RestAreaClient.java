package com.mini.mini_2.client.rest_area;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mini.mini_2.client.rest_area.domain.RestAreaRequestDTO;
import com.mini.mini_2.client.rest_area.domain.RestAreaResponseDTO;


@FeignClient(
    name = "restarea-service"
)
public interface RestAreaClient {

    @GetMapping("/api/v1/mini/restarea/lists/restarea/{restAreaId}")
    RestAreaResponseDTO findById(@PathVariable("restAreaId") Integer restAreaId);

    @GetMapping("/api/v1/mini/restarea/lists")
    List<RestAreaResponseDTO> findAll();

    @GetMapping("/api/v1/mini/restarea/code/{stdRestCd}")
    RestAreaResponseDTO findByCode(@PathVariable("stdRestCd")  String stdRestCd);

    @PostMapping("/api/v1/mini/restArea/create")
    RestAreaResponseDTO create(RestAreaRequestDTO restAreaRequestDTO);
}
