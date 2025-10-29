package com.mini.mini_2.favorite.domain.dto;

import com.mini.mini_2.favorite.domain.entity.FavoriteEntity;

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
public class FavoriteRequestDTO {
    private Integer userId;
    private Integer restAreaId;
    
    private String description;
    
    public FavoriteEntity toEntity() {
        return FavoriteEntity.builder()
                             .userId(Integer.toString(this.userId))
                             .restAreaId(Integer.toString(this.restAreaId))
                             .description(this.description)
                             .build();
    }
}
