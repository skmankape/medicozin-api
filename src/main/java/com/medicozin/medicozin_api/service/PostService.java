package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.Posts;
import com.medicozin.medicozin_api.repository.PostRepository;
import com.medicozin.medicozin_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private StudentRepository studentRepository;

    private static final String UPLOADED_FOLDER = "C:/Users/venka/medicozin-api/uploads/";

    public Posts createPost(Long studentId, String content, String type, MultipartFile image) {
        Posts post = new Posts();
        post.setStudentEntity(studentRepository.findById(studentId).orElse(null));
        post.setContent(content);
        post.setType(type);

        if (image != null && !image.isEmpty()) {
            try {
                String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
                Path path = Paths.get(UPLOADED_FOLDER + fileName);
                Files.createDirectories(path.getParent());
                Files.write(path, image.getBytes());
                // Store the image URL
                post.setImageUrl("http://192.168.1.5:9091/uploads/" + fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return postRepository.save(post);
    }


    public List<Posts> getAllPosts() {
        return postRepository.findAll();
    }
}
