package com.mini.mini_2.client.restarea;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mini.mini_2.client.restarea.domain.RestAreaRequestDTO;
import com.mini.mini_2.client.restarea.domain.RestAreaResponseDTO;

@FeignClient(
    name = "restarea-service"
)
public interface RestAreaClient {
    @GetMapping("/api/v1/mini/restarea/lists/restarea/{restAreaId}")
    RestAreaResponseDTO findById(@PathVariable("restAreaId") Integer restAreaId);

    @GetMapping("/api/v1/mini/restarea/lists/restarea/code/{stdRestCd}")
    RestAreaResponseDTO findByCode(@PathVariable("stdRestCd")  String stdRestCd);

    @GetMapping("/api/v1/mini/restarea/lists")
    List<RestAreaResponseDTO> findAll();

    @PostMapping("/api/v1/mini/restarea/create")
    RestAreaResponseDTO create(RestAreaRequestDTO restAreaRequestDTO);

}
