package com.medicozin.medicozin_api.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class CommentRequest {
    private UUID postId;
    private UUID studentId;
    private String content;

    public UUID getStudentId() {
        return null;
    }
}
