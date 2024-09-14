package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.CommentDTO;
import com.medicozin.medicozin_api.entity.PostDetailDTO;
import com.medicozin.medicozin_api.entity.Posts;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PostRepository extends JpaRepository<Posts,Long> {

    @Query("SELECT p.postId,p.type,p.imageUrl, p.createdAt,p.content FROM Posts p WHERE p.studentEntity.id = :userId")
    List<Object[]> findAllByuserId(@Param("userId") Long userId);
//    @Query("SELECT po.postId,po.content, po.createdAt, po.imageUrl, po.type, po.studentEntity.id, pr.imageUrl,st.firstname,st.lastname,st.specialization,st.collagename " +
//            "FROM Posts po " +
//            "INNER JOIN Profile pr ON po.studentEntity.id = pr.StudentId " +
//            "INNER JOIN StudentEntity st ON po.studentEntity.id = st.studentId " )
//    List<Object[]> findAllData(@Param("studentId") Long studentId);

    @Query("SELECT po.postId, po.content, po.createdAt, po.imageUrl, po.type, po.studentEntity.id, pr.imageUrl, st.firstname, st.lastname, st.specialization, st.collagename, " +
            "(SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END " +
            " FROM FollowersEntity f WHERE f.follower.id = :studentId AND f.studentId = po.studentEntity.id) AS isFollowed " +
            "FROM Posts po " +
            "INNER JOIN Profile pr ON po.studentEntity.id = pr.StudentId " +
            "INNER JOIN StudentEntity st ON po.studentEntity.id = st.studentId")
    List<Object[]> findAllData(@Param("studentId") Long studentId);

}
