package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.FollowingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowingRepository extends JpaRepository<FollowingEntity, Long> {
    List<FollowingEntity> findByStudentId(Long studentId);
}
