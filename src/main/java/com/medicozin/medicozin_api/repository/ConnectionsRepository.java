package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.ConnectionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ConnectionsRepository extends JpaRepository<ConnectionsEntity, UUID> {
    List<ConnectionsEntity> findByStudentId(UUID studentId);
}
