package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.Posts;
import com.medicozin.medicozin_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController

public class PostsController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public Posts createPost(
            @RequestParam Long studentId,
            @RequestParam String content,
            @RequestParam String type,
            @RequestParam(required = false) MultipartFile image) {
        return postService.createPost(studentId, content, type, image);
    }

    @GetMapping("/getAll")
    public List<Posts> getAllPosts() {
        return postService.getAllPosts();
    }
}
