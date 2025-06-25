package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity> findByEmail(String email);

    boolean existsByEmail(String email);
}
