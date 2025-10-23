package com.mini.mini_2.favorite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini.mini_2.client.rest_area.RestAreaClient;
import com.mini.mini_2.client.rest_area.domain.RestAreaResponseDTO;
import com.mini.mini_2.client.user.UserClient;
import com.mini.mini_2.client.user.domain.UserResponseDTO;
import com.mini.mini_2.favorite.domain.dto.FavoriteRequestDTO;
import com.mini.mini_2.favorite.domain.dto.FavoriteResponseDTO;
import com.mini.mini_2.favorite.domain.entity.FavoriteEntity;
import com.mini.mini_2.favorite.repository.FavoriteRepository;
import com.mini.mini_2.rest_area.domain.entity.RestAreaEntity;
import com.mini.mini_2.rest_area.repository.RestAreaRepository;
import com.mini.mini_2.user.domain.entity.UserEntity;
import com.mini.mini_2.user.repository.UserRepository;

@Service
public class FavoriteService {
    
    @Autowired
    private FavoriteRepository favoriteRepository;
    
    @Autowired 
    private UserClient userClient;
    
    @Autowired
    private RestAreaClient restAreaClient;
    
    // 즐겨찾기 생성
    public FavoriteResponseDTO create(FavoriteRequestDTO request) {
        System.out.println("[FavoriteService] create : " +request);
        
        UserResponseDTO userEntity = userClient.findById(request.getUserId());
        RestAreaResponseDTO restAreaEntity = restAreaRepository.findById(request.getRestAreaId());
        
        System.out.println("user client : " + userEntity);
        System.out.println("restarea client : " + restAreaEntity);

        FavoriteEntity entity = favoriteRepository.save(request.toEntity());
        return FavoriteResponseDTO.fromEntity(entity);
    }
    
    // 즐겨찾기 삭제
    public void delete(Integer favoriteId) {
        System.out.println("[FavoriteService] delete : "+ favoriteId);
        
        favoriteRepository.deleteById(favoriteId);
        
    }

    // ID 기반 즐겨찾기 단건 조회
    public List<FavoriteResponseDTO> findByUserId(Integer userId) {
        System.out.println("[FavoriteService] findByUserId : "+ userId);

        List<FavoriteEntity> entities = favoriteRepository.findAllByUser_UserId(userId);
        
        return entities.stream()
                       .map(entity -> FavoriteResponseDTO.fromEntity(entity))
                       .toList();
        
    }
}
