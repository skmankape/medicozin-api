package com.medicozin.medicozin_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    @Id
    @GeneratedValue
    private Long commentId;
    @ManyToOne
    @JoinColumn(name="studentId",nullable = false)
    private StudentEntity studentEntity;
    @ManyToOne
    @JoinColumn(name="postId",nullable = false)
    private Posts posts;

    @Lob // Use this annotation for large text content
    private String content;

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
