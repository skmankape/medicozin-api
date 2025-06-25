package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.Profile;
import com.medicozin.medicozin_api.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    private static final String UPLOADED_FOLDER = "D:/medicozin/medicozin-api/uploads/";

    public Profile createPost(UUID studentId, MultipartFile image) {
        Profile post;
        // Check if a Profile already exists for this studentId
        Optional<Profile> existingProfile = profileRepository.findByStudentId(studentId);

        if (existingProfile.isPresent()) {
            // Use the existing profile
            post = existingProfile.get();
        } else {
            // Create a new profile
            post = new Profile();
            post.setStudentId(studentId);
        }


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

        return profileRepository.save(post);
    }
    public List<Object[]> getAllPostsbyId(UUID userid) {
        return profileRepository.findAllByuserId(userid);
    }
}
