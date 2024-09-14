package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.PostDetailDTO;
import com.medicozin.medicozin_api.entity.Posts;
import com.medicozin.medicozin_api.repository.PostRepository;
import com.medicozin.medicozin_api.repository.StudentRepository;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

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
                post.setImageUrl("/uploads/" + fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return postRepository.save(post);
    }



    public List<Map<String, Object>> getAllPosts(Long studentId) {
        List<Object[]> results = postRepository.findAllData(studentId);
        List<Map<String, Object>> posts = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> postMap = new HashMap<>();
            postMap.put("postId", result[0]);
            postMap.put("content", result[1]);
            postMap.put("createdAt", result[2]);
            postMap.put("imageUrl", result[3]);
            postMap.put("type", result[4]);
            postMap.put("studentId", result[5]);
            postMap.put("profileImageUrl", result[6]);
            postMap.put("firstname", result[7]);
            postMap.put("lastname", result[8]);
            postMap.put("specialization", result[9]);
            postMap.put("collagename", result[10]);
            postMap.put("folooweststus", result[11]);
            posts.add(postMap);
        }

        return posts;
    }

//    public List<Posts> getAllPosts(){
//        return postRepository.findAll();
//    }
    public List<Object[]> getAllPostsbyId(Long userid) {
        return postRepository.findAllByuserId(userid);
    }


}
