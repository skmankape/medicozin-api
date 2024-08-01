package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.FollowersEntity;
import com.medicozin.medicozin_api.repository.FollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowersService {
    @Autowired
     private FollowersRepository followersRepository;

    public FollowersEntity addFollower(FollowersEntity follower) {
        return followersRepository.save(follower);
    }

    public List<FollowersEntity> getAllFollowers() {
        return followersRepository.findAll();
    }
}
