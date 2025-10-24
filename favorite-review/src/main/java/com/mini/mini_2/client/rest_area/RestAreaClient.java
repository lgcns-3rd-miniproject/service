package com.mini.mini_2.client.rest_area;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mini.mini_2.client.rest_area.domain.RestAreaResponseDTO;


@FeignClient(

    name = "restarea-service"
    //url = "${GATEWAY_URL:http://service-restarea-1:8080}"
    //name = "restarea-service", 
    //url = "${RESTAREA_SERVICE_URL:http://localhost:8888}"
)
public interface RestAreaClient {

    @GetMapping("/api/v1/mini/restarea/lists/restarea/{restAreaId}")
    RestAreaResponseDTO findById(@PathVariable("restAreaId") Integer restAreaId);

    @GetMapping("/api/v1/mini/restarea/lists")
    List<RestAreaResponseDTO> findAll();
}
