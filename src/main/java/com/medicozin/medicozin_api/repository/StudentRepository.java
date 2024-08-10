package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findByEmail(String email);


    boolean existsByEmail(String email);

    @Query("SELECT s.collagename, s.email, s.firstname, s.lastname, s.mobileno, s.specialization FROM StudentEntity s WHERE s.studentId= :userId")
    Optional<Object[]> findStudentDetailsByUserId(@Param("userId") Long userId);
    @Query(value = "SELECT s.student_id,s.collagename, s.email, s.firstname, s.lastname, s.mobileno, s.specialization FROM Student s " +
            "INNER JOIN Followers f ON s.student_id = f.student_id " +
            "WHERE f.followeruserid = :followerUserId",
            nativeQuery = true)
    Optional<Object[]> findByFollowerStudentId(@Param("followerUserId") Long followerUserId);

}
