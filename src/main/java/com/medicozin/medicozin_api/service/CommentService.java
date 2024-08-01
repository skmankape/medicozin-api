package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.CommentDTO;
import com.medicozin.medicozin_api.entity.Comments;
import com.medicozin.medicozin_api.entity.Posts;
import com.medicozin.medicozin_api.entity.StudentEntity;
import com.medicozin.medicozin_api.repository.CommentRepository;
import com.medicozin.medicozin_api.repository.PostRepository;
import com.medicozin.medicozin_api.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PostRepository postRepository;

    public Comments createComment(Long postId, Long studentId, String content) {
        // Retrieve the post and student entities from the database
        Posts post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Create the Comments entity
        Comments comment = new Comments();
        comment.setPosts(post); // Use the Posts entity, not the ID
        comment.setStudentEntity(student); // Use the StudentEntity, not the ID
        comment.setContent(content);

        // Save the comment
        return commentRepository.save(comment);
    }

    public List<CommentDTO> getAllCommentsForPost(Long postId) {
        return commentRepository.findCommentsByPostId(postId);
    }
}
