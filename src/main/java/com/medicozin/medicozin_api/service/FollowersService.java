package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.FollowersEntity;
import com.medicozin.medicozin_api.repository.FollowersRepository;
import com.medicozin.medicozin_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FollowersService {

    @Autowired
    private FollowersRepository followersRepository;
    @Autowired
    private StudentRepository studentRepository;

    public FollowersEntity saveFollower(FollowersEntity follower) {
        return followersRepository.save(follower);
    }

    public Optional<Object[]> getFollowersByStudentId(UUID followerStudentId) {
        return studentRepository.findByFollowerStudentId2(followerStudentId);
    }

    public Optional<Object[]> getFollowersByFollowerStudentId(UUID followerStudentId) {
        return studentRepository.findByFollowerStudentId(followerStudentId); // Implement this in the repository
    }


}
