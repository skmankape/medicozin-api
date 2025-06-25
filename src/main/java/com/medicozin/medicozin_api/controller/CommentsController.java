package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.CommentDTO;
import com.medicozin.medicozin_api.entity.CommentRequest;
import com.medicozin.medicozin_api.entity.Comments;
import com.medicozin.medicozin_api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/createComment")
    public Comments createComment(@RequestBody CommentRequest commentRequest) {
        return commentService.createComment(commentRequest.getPostId(), commentRequest.getStudentId(), commentRequest.getContent());
    }

    @GetMapping("/getComments/{id}")
    public List<CommentDTO> getAllComments(@PathVariable UUID id) {
        return commentService.getAllCommentsForPost(id);
    }
}
