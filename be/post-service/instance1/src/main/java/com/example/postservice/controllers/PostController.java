package com.example.postservice.controllers;

import com.example.postservice.client.UserServiceClient;
import com.example.postservice.dtos.UserDTO;
import com.example.postservice.entities.Comment;
import com.example.postservice.entities.Like;
import com.example.postservice.entities.Post;
import com.example.postservice.entities.Share;
import com.example.postservice.repositories.CommentRepository;
import com.example.postservice.repositories.LikeRepository;
import com.example.postservice.repositories.PostRepository;
import com.example.postservice.repositories.ShareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private ShareRepository shareRepository;

    @Autowired
    private UserServiceClient userServiceClient;

    @GetMapping("/get-list-posts")
    public List<Map<String, Object>> getListPost(@RequestParam String userId) {
//        List<Map<String, Object>> listResponse = postRepository.getListPost(userId);
//        Set<Long> listUserComment = listResponse.stream().map(x -> Long.parseLong(x.get("user_id_comment").toString())).collect(Collectors.toSet());
//        Map<String, Set<Long>> setMap = new HashMap<>();
//        setMap.put("listUserId", listUserComment);
//        List<UserDTO> userDTOS = userServiceClient.getListUser(setMap);
//        listResponse = listResponse.stream().map(x -> {
//            Map<String, Object> clonedMap = new HashMap<>(x);
//
//            for (UserDTO userDTO : userDTOS) {
//                if (Long.valueOf(x.get("user_id_comment").toString()).equals(userDTO.getId())) {
//                    clonedMap.put("user_comment", userDTO);
//                    clonedMap.remove("user_id_comment");
//                    break;
//                }
//            }
//
//            return clonedMap;
//        }).toList();
//
//        return listResponse;




        List<Map<String, Object>> listResponse = new ArrayList<>();

        return listResponse;
    }
}
