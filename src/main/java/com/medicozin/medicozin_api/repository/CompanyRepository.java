package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity,Long> {
    Optional<CompanyEntity> findByEmail(String email);
}
