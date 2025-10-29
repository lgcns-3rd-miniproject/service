package com.mini.mini_2.facility.domain.dto;

import com.mini.mini_2.client.rest_area.domain.RestAreaResponseDTO;
import com.mini.mini_2.facility.domain.entity.FacilityEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityRequestDTO {

    private Integer restAreaId;
    private String  name;
    private String  description;
    
    public FacilityEntity toEntity(RestAreaResponseDTO restArea) {
        return FacilityEntity.builder()
                .restAreaId(restArea.getRestAreaId())
                .name(this.name)
                .description(this.description)
                .build();
    }
    
}
