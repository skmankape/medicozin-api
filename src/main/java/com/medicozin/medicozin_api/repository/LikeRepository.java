package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.Likes;
import com.medicozin.medicozin_api.entity.Posts;
import com.medicozin.medicozin_api.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LikeRepository extends JpaRepository<Likes,UUID> {
    List<Likes> findByPostsPostId(UUID postId);
    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END " +
            "FROM Likes l WHERE l.posts.id = :postId AND l.studentEntity.id = :studentId")
    boolean existsByPostIdAndStudentId(@Param("postId") UUID postId, @Param("studentId") UUID studentId);

    Long countByPostsPostId(UUID postId); // to get count of likes on post


    Likes findByPostsAndStudentEntity(Posts posts, StudentEntity studentEntity);
}
