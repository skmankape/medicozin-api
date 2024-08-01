package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.FollowersEntity;
import com.medicozin.medicozin_api.service.FollowersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FollowersController {
    @Autowired
    private FollowersService followerService;

    @PostMapping("/followers")
    public FollowersEntity addFollower(@RequestBody FollowersEntity follower) {
        return followerService.addFollower(follower);
    }

    @GetMapping("/getFollowers")
    public List<FollowersEntity> getAllFollowers() {
        return followerService.getAllFollowers();
    }
}
