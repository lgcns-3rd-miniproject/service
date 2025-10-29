package com.mini.mini_2.review.domain.dto;

import com.mini.mini_2.review.domain.entity.ReviewEntity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter     // Controller에서 userId를 주입하기 위해 필요
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewRequestDTO {
    private Integer userId;
    private Integer restAreaId;
    
    private String rating;
    private String comment;
    
    public ReviewEntity toEntity() {
        return ReviewEntity.builder()
                         .userId(this.userId) // DTO의 ID 필드 사용
                         .restAreaId(this.restAreaId) // DTO의 ID 필드 사용
                         .rating(this.rating)
                         .comment(this.comment)
                         .build();
    }
}
