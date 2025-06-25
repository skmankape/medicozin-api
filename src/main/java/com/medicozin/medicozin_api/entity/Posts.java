package com.medicozin.medicozin_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Posts {

    @Id
    @GeneratedValue
    private UUID postId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity studentEntity;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String type;



    // Add image URL field
    private String imageUrl;



    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false)
    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    private Date createdAt;
    private Date updatedAt;
}
