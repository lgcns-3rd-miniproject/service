package com.mini.mini_2.client.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mini.mini_2.client.user.domain.UserResponseDTO;

@FeignClient(
    // TODO: 경로 바꾸기!! 아마 휴게소도
    name = "user-service"
    //url = "${GATEWAY_URL:http://service-user-1:8080}"
)
public interface UserClient {
    
    @GetMapping("/api/v1/mini/user/{id}")
    UserResponseDTO findById(@PathVariable("id") Integer id);
    

}
