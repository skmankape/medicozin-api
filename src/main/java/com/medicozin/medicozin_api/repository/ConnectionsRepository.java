package com.medicozin.medicozin_api.repository;

import com.medicozin.medicozin_api.entity.ConnectionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionsRepository extends JpaRepository<ConnectionsEntity, Long> {
    List<ConnectionsEntity> findByStudentId(Long studentId);
}
