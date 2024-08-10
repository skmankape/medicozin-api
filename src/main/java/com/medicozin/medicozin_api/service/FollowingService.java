package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.FollowingEntity;
import com.medicozin.medicozin_api.repository.FollowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowingService {

    @Autowired
    private FollowingRepository followingRepository;

    public FollowingEntity saveFollowing(FollowingEntity following) {
        return followingRepository.save(following);
    }

    public List<FollowingEntity> getFollowingByStudentId(Long studentId) {
        return followingRepository.findByStudentId(studentId);
    }
}
