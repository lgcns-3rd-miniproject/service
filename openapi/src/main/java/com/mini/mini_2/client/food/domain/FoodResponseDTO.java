package com.mini.mini_2.client.food.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FoodResponseDTO {
    private Integer foodId;
    private Integer restAreaId;
    private String  foodName;
    private String  price;
    private String  isSignature;
    private String  description;
}
