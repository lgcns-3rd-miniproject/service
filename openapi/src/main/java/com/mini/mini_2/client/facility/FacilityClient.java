package com.mini.mini_2.client.facility;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PostMapping;

import com.mini.mini_2.client.facility.domain.FacilityRequestDTO;
import com.mini.mini_2.client.facility.domain.FacilityResponseDTO;


@FeignClient(
    name = "restarea-unit-service"
)

public interface FacilityClient {
    @PostMapping("/api/v1/mini/facility/create")
    FacilityResponseDTO create(FacilityRequestDTO facilityRequestDTO);

}
