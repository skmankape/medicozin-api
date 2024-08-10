package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.FollowingEntity;
import com.medicozin.medicozin_api.service.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class FollowingController {

    @Autowired
    private FollowingService followingService;

    @PostMapping("/createFollowing")
    public FollowingEntity createFollowing(@RequestBody FollowingEntity following) {
        return followingService.saveFollowing(following);
    }

    @GetMapping("/getFollowing/{studentId}")
    public List<FollowingEntity> getFollowingByStudentId(@PathVariable Long studentId) {
        return followingService.getFollowingByStudentId(studentId);
    }
}
