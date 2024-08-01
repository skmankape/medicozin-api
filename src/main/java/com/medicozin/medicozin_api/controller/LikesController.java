package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.Likes;
import com.medicozin.medicozin_api.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Base URL for your API
public class LikesController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/createLike")
    public Likes createLike(@RequestBody LikeRequest likeRequest) {
        return likeService.createLike(likeRequest.getPostId(), likeRequest.getStudentId());
    }

    @GetMapping("/getLikes/{postId}")
    public List<Likes> getLikes(@PathVariable Long postId) {
        return likeService.getAllLikesByPost(postId);
    }
    @PostMapping("/Likestatus")
    public boolean getLikeStatus(@RequestBody LikeStatusRequest request) {
        Long postId = request.getPostId();
        Long studentId = request.getStudentId();
        return likeService.hasLikedPost(postId, studentId);
    }
    @DeleteMapping("/deleteLike")
    public ResponseEntity<Void> deleteLike(@RequestBody LikeRequest likeRequest) {
        try {
            likeService.deleteLike(likeRequest.getPostId(), likeRequest.getStudentId());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

// Helper class for the request body
class LikeRequest {
    private Long postId;
    private Long studentId;

    // Getters and Setters
    public Long getPostId() { return postId; }
    public void setPostId(Long postId) { this.postId = postId; }
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
}
class LikeStatusRequest {
    private Long postId;
    private Long studentId;

    // Getters and setters
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
