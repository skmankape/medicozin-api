package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.DoctorEntity;
import com.medicozin.medicozin_api.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<DoctorEntity, UUID> {
    Optional<DoctorEntity> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("SELECT d.collagename, d.email, d.firstname, d.lastname, d.mobileno, d.specialization, d.gender , d.dob, d.location, d.year  FROM DoctorEntity d WHERE d.doctorid= :userId")
    Optional<Object[]> findDoctorDetailsByUserId(@Param("userId") UUID userId);
}
