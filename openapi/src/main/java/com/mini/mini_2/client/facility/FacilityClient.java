package com.mini.mini_2.client.facility;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mini.mini_2.client.facility.domain.FacilityResponseDTO;


@FeignClient(
    name = "facility-service", 
    url = "${FOOD_SERVICE_URL:http://localhost:8888}"
)

public interface FacilityClient {
    @GetMapping("/api/v1/mini/restarea/lists/facility/{facilityId}")
    FacilityResponseDTO findById(@PathVariable("facilityId") Integer facilityId);

    @GetMapping("/api/v1/mini/facility/lists")
    List<FacilityResponseDTO> findAll();
}
