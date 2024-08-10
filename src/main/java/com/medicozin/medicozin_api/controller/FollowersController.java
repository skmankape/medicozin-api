package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.FollowersEntity;
import com.medicozin.medicozin_api.service.FollowersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FollowersController {

    @Autowired
    private FollowersService followersService;

    @PostMapping("/ceateFollowers")
    public FollowersEntity createFollower(@RequestBody FollowersEntity follower) {
        return followersService.saveFollower(follower);
    }


//@GetMapping("/getFollowers/{studentId}")
//public List<FollowersEntity> getFollowersByStudentId(@PathVariable Long studentId) {
//    return followersService.getFollowersByFollowerStudentId(studentId);
//}
@GetMapping("/getFollowers/{studentId}")
public List<FollowersEntity> getFollowersByStudentId(@PathVariable Long studentId) {
    return followersService.getFollowersByStudentId(studentId);
}
    @GetMapping("/getFollowingg/{followerStudentId}")
    public Optional<Object[]> getFollowersByFollowerStudentId(@PathVariable Long followerStudentId) {
        return followersService.getFollowersByFollowerStudentId(followerStudentId);
    }
}
