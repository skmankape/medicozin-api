package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.DoctorEntity;
import com.medicozin.medicozin_api.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<DoctorEntity,Long> {
    Optional<DoctorEntity> findByEmail(String email);

    boolean existsByEmail(String email);
}
