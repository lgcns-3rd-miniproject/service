package com.mini.mini_2.client.restarea;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mini.mini_2.client.restarea.domain.RestAreaResponseDTO;


@FeignClient(
    name = "restarea-service" 
    //url = "${GATEWAY_URL:http://service-restarea-1:8080}"
)

public interface RestAreaClient {
    @GetMapping("/api/v1/mini/restarea/lists")
    List<RestAreaResponseDTO> findAll();
}