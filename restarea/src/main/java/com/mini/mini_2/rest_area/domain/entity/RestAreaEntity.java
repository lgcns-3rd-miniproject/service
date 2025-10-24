package com.mini.mini_2.rest_area.domain.entity;

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

@Entity
@Table(name = "rest_area")

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RestAreaEntity {

    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restAreaId;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String direction;

    @Column(nullable = false, unique = true, length = 100)
    private String code;

    @Column(length = 50)
    private String tel;

    @Column(length = 100)
    private String address;

    @Column(length = 100)
    private String routeName;

    @Column(length = 100)
    private String xValue;

    @Column(length = 100)
    private String yValue;

}
