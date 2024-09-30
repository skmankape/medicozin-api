package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findByEmail(String email);


    boolean existsByEmail(String email);

    @Query("SELECT s.collagename, s.email, s.firstname, s.lastname, s.mobileno, s.specialization FROM StudentEntity s WHERE s.studentId= :userId")
    Optional<Object[]> findStudentDetailsByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT s.student_id,s.collagename, s.email, s.firstname, s.lastname, s.mobileno, s.specialization,p.image_url FROM Student s " +
            "INNER JOIN Followers f ON s.student_id = f.student_id " +
            "INNER JOIN Profile p ON s.student_id=p.student_id " +
            "WHERE f.followeruserid = :followerUserId",
            nativeQuery = true)
    Optional<Object[]> findByFollowerStudentId(@Param("followerUserId") Long followerUserId);


    @Query(value = "SELECT s.student_id,s.collagename, s.email, s.firstname, s.lastname, s.mobileno, s.specialization,p.image_url FROM Student s " +
            "INNER JOIN Followers f ON s.student_id = f.followeruserid " +
            "INNER JOIN Profile p ON s.student_id=p.student_id " +
            "WHERE f.student_id = :followerUserId",
            nativeQuery = true)
    Optional<Object[]> findByFollowerStudentId2(@Param("followerUserId") Long followerUserId);

    @Query(value = "SELECT s.student_id,s.collagename, s.email, s.firstname, s.lastname, s.mobileno, s.specialization,p.image_url FROM Student s " +
            "INNER JOIN Connections c ON s.student_id = c.connection_id " +
            "INNER JOIN Profile p ON s.student_id=p.student_id " +
            "WHERE c.student_id = :followerUserId and c.status=0",
            nativeQuery = true)
    Optional<Object[]> findByFollowerStudentId3(@Param("followerUserId") Long followerUserId);
}
