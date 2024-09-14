package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.FollowersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowersRepository extends JpaRepository<FollowersEntity,Long> {
    List<FollowersEntity> findByStudentId(Long studentId);
//    List<FollowersEntity> findByFollowerStudentId(Long followerStudentId);

//    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM FollowersEntity f WHERE f.follower.id = :followeruserid AND f.studentId = :studentId")
//    boolean existsByFolloweruseridAndStudentId(@Param("followeruserid") Long followeruserid, @Param("studentId") Long studentId);
}

