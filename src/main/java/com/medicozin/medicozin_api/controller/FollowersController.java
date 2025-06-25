package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.FollowersEntity;
import com.medicozin.medicozin_api.service.FollowersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class FollowersController {

    @Autowired
    private FollowersService followersService;

    @PostMapping("/ceateFollowers")
    public FollowersEntity createFollower(@RequestBody FollowersEntity follower) {
//         System.out.println(("jffj "+follower));
        return followersService.saveFollower(follower);
    }


//@GetMapping("/getFollowers/{studentId}")
//public List<FollowersEntity> getFollowersByStudentId(@PathVariable Long studentId) {
//    return followersService.getFollowersByFollowerStudentId(studentId);
//}
@GetMapping("/getFollowers/{studentId}")
public Optional<Object[]> getFollowersByStudentId(@PathVariable UUID studentId) {
    return followersService.getFollowersByStudentId(studentId);
}
    @GetMapping("/getFollowingg/{followerStudentId}")
    public Optional<Object[]> getFollowersByFollowerStudentId(@PathVariable UUID followerStudentId) {
        return followersService.getFollowersByFollowerStudentId(followerStudentId);
    }


}
