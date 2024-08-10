package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.Profile;
import com.medicozin.medicozin_api.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @PutMapping("/createprofilePic")
    public Profile createPost(
            @RequestParam Long studentId,
            @RequestParam(required = false) MultipartFile image) {
        return profileService.createPost(studentId, image);
    }
    @GetMapping("/getProfilepicbyId/{userId}")
    public List<Object[]> getAllPostsbyId(@PathVariable Long userId) {
        return profileService.getAllPostsbyId(userId);
    }
}
