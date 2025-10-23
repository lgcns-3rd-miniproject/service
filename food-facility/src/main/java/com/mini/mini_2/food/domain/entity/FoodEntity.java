package com.mini.mini_2.food.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "food")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"restArea"})
public class FoodEntity {
    
    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;
    
    // FK
    @Column(nullable = false)
    private Integer restAreaId;
    
    @Column(nullable = false , 
            length = 50)
    private String foodName ;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private String isSignature;

    @Column(length = 1000)
    private String description;

}
