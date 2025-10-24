package com.mini.mini_2.food.domain.dto;

import com.mini.mini_2.client.rest_area.domain.RestAreaResponseDTO;
import com.mini.mini_2.food.domain.entity.FoodEntity;

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
public class FoodRequestDTO {
    
    private Integer restAreaId;  
    private String  foodName;     
    private String  price;
    private String  isSignature;
    private String  description;

    public FoodEntity toEntity(RestAreaResponseDTO restArea) {
        return FoodEntity.builder()
                .restAreaId(restArea.getRestAreaId()) 
                .foodName(this.foodName)
                .price(this.price)
                .isSignature(this.isSignature)
                .description(this.description)
                .build();
    }
   
}
