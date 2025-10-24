package com.mini.mini_2.facility.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mini.mini_2.facility.domain.entity.FacilityEntity;

@Repository
public interface FacilityRepository extends JpaRepository<FacilityEntity, Integer> {
    List<FacilityEntity> findAllByNameIn(List<String> name);
    List<FacilityEntity> findByRestAreaId(Integer restAreaId);
}
