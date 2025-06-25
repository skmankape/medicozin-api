package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.ConnectionsEntity;
import com.medicozin.medicozin_api.repository.ConnectionsRepository;
import com.medicozin.medicozin_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ConnectionsService {

    @Autowired
    private ConnectionsRepository connectionsRepository;

    @Autowired
    private StudentRepository studentRepository;

    public ConnectionsEntity saveConnection(ConnectionsEntity connection) {
        return connectionsRepository.save(connection);
    }

    public Optional<Object[]> getConnectionsByStudentId(UUID studentId) {
        return studentRepository.findByFollowerStudentId3(studentId);
    }
}
