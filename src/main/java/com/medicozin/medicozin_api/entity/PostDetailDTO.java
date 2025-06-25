package com.medicozin.medicozin_api.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class PostDetailDTO {
    private String content;
    private Date createdAt;
    private String imageUrl;
    private String type;
    private UUID studentId;
    private String profileImageUrl;

    // Constructors, getters, and setters

    public PostDetailDTO(String content, Date createdAt, String imageUrl, String type, UUID studentId, String profileImageUrl) {
        this.content = content;
        this.createdAt = createdAt;
        this.imageUrl = imageUrl;
        this.type = type;
        this.studentId = studentId;
        this.profileImageUrl = profileImageUrl;
    }
}
