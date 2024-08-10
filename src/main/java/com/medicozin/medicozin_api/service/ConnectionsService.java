package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.ConnectionsEntity;
import com.medicozin.medicozin_api.repository.ConnectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionsService {

    @Autowired
    private ConnectionsRepository connectionsRepository;

    public ConnectionsEntity saveConnection(ConnectionsEntity connection) {
        return connectionsRepository.save(connection);
    }

    public List<ConnectionsEntity> getConnectionsByStudentId(Long studentId) {
        return connectionsRepository.findByStudentId(studentId);
    }
}
