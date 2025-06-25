package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.CommentDTO;
import com.medicozin.medicozin_api.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comments, UUID> {
    @Query("SELECT new  com.medicozin.medicozin_api.entity.CommentDTO(c.content, s.firstname, s.lastname) " +
            "FROM Comments c INNER JOIN c.studentEntity s WHERE c.posts.id = :postId")
    List<CommentDTO> findCommentsByPostId(@Param("postId") UUID postId);


}
