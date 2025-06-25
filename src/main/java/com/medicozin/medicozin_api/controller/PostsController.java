package com.medicozin.medicozin_api.controller;


import com.medicozin.medicozin_api.entity.PostDetailDTO;
import com.medicozin.medicozin_api.entity.Posts;
import com.medicozin.medicozin_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController

public class PostsController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public Posts createPost(
            @RequestParam UUID studentId,
            @RequestParam String content,
            @RequestParam String type,
            @RequestParam(required = false) MultipartFile image) {System.out.println("Student ID: " + studentId);

        return postService.createPost(studentId, content, type, image);
    }

    @GetMapping("/getAll/{studentId}")
    public List<Map<String, Object>> getAllPosts(@PathVariable UUID studentId) {
        return postService.getAllPosts(studentId);
    }
//    public List<Posts> getAllPosts() {
//        return postService.getAllPosts();
//    }
    @GetMapping("/getAllbyId/{userId}")
    public List<Object[]> getAllPostsbyId(@PathVariable UUID userId) {
        return postService.getAllPostsbyId(userId);
    }
}
