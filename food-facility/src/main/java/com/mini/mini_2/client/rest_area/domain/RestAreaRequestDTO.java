package com.mini.mini_2.client.rest_area.domain;

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
public class RestAreaRequestDTO {
    
    private String name;
    private String direction;
    private String code;
    private String tel ;
    private String address ;
    private String routeName ;
    private String xValue ;
    private String yValue ;

}