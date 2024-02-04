package com.example.identityservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@FeignClient("post-service")
public interface PostServiceClient {
    @GetMapping("/post/get-list-posts")
    List<Map<String, Object>> getListPost(@RequestParam Long userId);
}
