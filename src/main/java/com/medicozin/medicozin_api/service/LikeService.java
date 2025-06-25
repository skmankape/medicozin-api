package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.Likes;
import com.medicozin.medicozin_api.entity.Posts;
import com.medicozin.medicozin_api.entity.StudentEntity;
import com.medicozin.medicozin_api.repository.LikeRepository;
import com.medicozin.medicozin_api.repository.PostRepository;
import com.medicozin.medicozin_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Likes createLike(UUID postId, UUID studentId) {
        // Retrieve the post and student entities from the database
        Posts post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Create the Like entity
        Likes like = new Likes();
        like.setPosts(post);
        like.setStudentEntity(student);

        // Save the like
        return likeRepository.save(like);
    }

    public List<Likes> getAllLikesByPost(UUID postId) {
        return likeRepository.findByPostsPostId(postId);
    }

    public Long countByPostsPostId(UUID postId) {
        return likeRepository.countByPostsPostId(postId);
    }

    public boolean hasLikedPost(UUID postId, UUID studentId) {
        return likeRepository.existsByPostIdAndStudentId(postId, studentId);
    }
    public void deleteLike(UUID postId, UUID studentId) {
        Posts post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Likes like = likeRepository.findByPostsAndStudentEntity(post, student);

        if (like != null) {
            likeRepository.delete(like);
        } else {
            throw new RuntimeException("Like not found");
        }
    }
}
