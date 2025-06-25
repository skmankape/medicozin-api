package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    @Query("SELECT p.imageUrl FROM Profile p WHERE p.StudentId = :userId")
    List<Object[]> findAllByuserId(@Param("userId") UUID userId);

    @Query("SELECT p FROM Profile p WHERE p.StudentId = :studentId")
    Optional<Profile> findByStudentId(@Param("studentId") UUID studentId);
}
