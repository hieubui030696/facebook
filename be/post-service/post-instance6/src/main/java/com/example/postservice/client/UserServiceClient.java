package com.example.postservice.client;

import com.example.postservice.dtos.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@FeignClient("IDENTITY-SERVICE")
public interface UserServiceClient {
    @PostMapping("/auth/get-by-list-user")
    List<UserDTO> getListUser(Map<String, Set<Long>> body);
}
