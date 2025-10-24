package com.mini.mini_2.facility.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini.mini_2.client.rest_area.RestAreaClient;
import com.mini.mini_2.client.rest_area.domain.RestAreaResponseDTO;
import com.mini.mini_2.facility.domain.dto.FacilityRequestDTO;
import com.mini.mini_2.facility.domain.dto.FacilityResponseDTO;
import com.mini.mini_2.facility.domain.entity.FacilityEntity;
import com.mini.mini_2.facility.repository.FacilityRepository;
import jakarta.transaction.Transactional;

@Service
public class FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private RestAreaClient restAreaClient;

    // 편의시설 생성
    @Transactional
    public FacilityResponseDTO create(FacilityRequestDTO request) {
        System.out.println("[FacilityService] create : "+ request);

        RestAreaResponseDTO restArea = restAreaClient.findById(request.getRestAreaId());

        if(restArea != null) {
            FacilityEntity facility = request.toEntity(restArea);
            return FacilityResponseDTO.fromEntity(facilityRepository.save(facility));
        }
        else {
            return null;
        }
    }
    
    // 휴게소 ID 기반 편의시설 조회
    public List<FacilityResponseDTO> findByRestAreaId(Integer restAreaId) {
        
        List<FacilityEntity> entities = facilityRepository.findByRestAreaId(restAreaId);
        
        return entities.stream()
                         .map(entity -> FacilityResponseDTO.fromEntity(entity))
                         .toList();
        
    }

    // 원하는 편의시설이 있는 휴게소 조회
    public List<RestAreaResponseDTO> searchByNames(List<String> names) {

        // 이름 전처리
        List<String> cleandNames = (names == null ? List.<String>of() : names)
                .stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .distinct()
                .toList() ;
        
        // 1. 퍼실리티에서 해당 네임인 애들을 다 가져오고, 
        // 2. 가져온 거에서 restareaid를 갖다가
        // 3. restareaclient로 get
        List<FacilityEntity> facilities = facilityRepository.findAllByNameIn(cleandNames);

        return facilities.stream()
            .map(FacilityEntity::getRestAreaId)
            .filter(Objects::nonNull)
            .distinct() 
            .map(restAreaClient::findById) 
            .filter(Objects::nonNull)
            .toList();
        
    }
}
