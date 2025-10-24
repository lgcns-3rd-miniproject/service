package com.mini.mini_2.client.restarea.domain;

import lombok.*;


@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RestAreaResponseDTO {
    
    private Integer restAreaId;
    private String name;
    private String direction;
    private String code;
    private String tel;
    private String address;
    private String routeName;
    private String xValue;
    private String yValue;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        RestAreaResponseDTO that = (RestAreaResponseDTO) o;
        return restAreaId != null && restAreaId.equals(that.restAreaId);
    }
    
    @Override
    public int hashCode() {
        return restAreaId != null ? restAreaId.hashCode() : 0;
    }
}


