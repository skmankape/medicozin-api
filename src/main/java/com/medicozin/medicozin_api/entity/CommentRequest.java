package com.medicozin.medicozin_api.entity;

import lombok.Data;

@Data
public class CommentRequest {
    private Long postId;
    private Long studentId;
    private String content;

    public Long getStudentId() {
        return null;
    }
}
