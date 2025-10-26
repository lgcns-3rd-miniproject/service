package com.mini.mini_2.facility.domain.entity;

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
@Table(name = "facility")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityEntity {

    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facility_id")
    private Integer facilityId;

    // FK(rest_area_id)
    private Integer restAreaId;

    @Column(length = 50)
    private String name; 
    
    @Column(length = 1000)
    private String description; 
    
}
