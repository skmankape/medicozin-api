package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.FollowersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowersRepository extends JpaRepository<FollowersEntity,Long> {
}
