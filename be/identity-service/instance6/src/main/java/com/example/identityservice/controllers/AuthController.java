package com.example.identityservice.controllers;

import com.example.identityservice.client.PostServiceClient;
import com.example.identityservice.entities.User;
import com.example.identityservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostServiceClient postServiceClient;

    @PostMapping("/get-by-list-user")
    public ResponseEntity<List<User>> getByListUser(@RequestBody Map<String, List<Long>> body) {
        return new ResponseEntity<>(userRepository.getListUser(body.get("listUserId")), HttpStatus.OK);
    }

    @GetMapping("/get-profile")
    public ResponseEntity<Object> getProfile(@RequestParam Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Map<String, Object> userResponse = new HashMap<>();
        List<Map<String, Object>> listPost = postServiceClient.getListPost(user.get().getId());
        userResponse.put("user", user.get());
        userResponse.put("listPost", listPost);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
