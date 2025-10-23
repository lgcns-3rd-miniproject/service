package com.mini.mini_2.client.restArea;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mini.mini_2.client.restArea.domain.RestAreaResponseDTO;


@FeignClient(
    name = "restArea-service", 
    url = "${RESTAREA_SERVICE_URL:http://localhost:8888}"
)
public interface RestAreaClient {
    @GetMapping("/api/v1/mini/restarea/lists/restArea/{restAreaId}")
    RestAreaResponseDTO findById(@PathVariable("restAreaId") Integer restAreaId);

    @GetMapping("/api/v1/mini/restArea/lists")
    List<RestAreaResponseDTO> findAll();
}
