package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Posts,Long> {
}
