package com.medicozin.medicozin_api.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDTO {
    // Getters and Setters
    private String content;
    private String firstName;
    private String lastName;

    // Constructor
    public CommentDTO(String content, String firstName, String lastName) {
        this.content = content;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}