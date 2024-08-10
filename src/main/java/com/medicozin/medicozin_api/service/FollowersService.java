package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.FollowersEntity;
import com.medicozin.medicozin_api.repository.FollowersRepository;
import com.medicozin.medicozin_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowersService {

    @Autowired
    private FollowersRepository followersRepository;
    @Autowired
    private StudentRepository studentRepository;

    public FollowersEntity saveFollower(FollowersEntity follower) {
        return followersRepository.save(follower);
    }

    public List<FollowersEntity> getFollowersByStudentId(Long studentId) {
        return followersRepository.findByStudentId(studentId);
    }

    public Optional<Object[]> getFollowersByFollowerStudentId(Long followerStudentId) {
        return studentRepository.findByFollowerStudentId(followerStudentId); // Implement this in the repository
    }
}
