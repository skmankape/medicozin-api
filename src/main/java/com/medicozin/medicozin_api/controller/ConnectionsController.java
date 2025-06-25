package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.ConnectionsEntity;
import com.medicozin.medicozin_api.service.ConnectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class ConnectionsController {

    @Autowired
    private ConnectionsService connectionsService;

    @PostMapping("/createConnection")
    public ConnectionsEntity createConnection(@RequestBody ConnectionsEntity connection) {
        return connectionsService.saveConnection(connection);
    }

    @GetMapping("/getConnections/{studentId}")
    public Optional<Object[]> getConnectionsByStudentId(@PathVariable UUID studentId) {
        return connectionsService.getConnectionsByStudentId(studentId);
    }
}
