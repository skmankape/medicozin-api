package com.medicozin.medicozin_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Connections")
public class ConnectionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "connectionsId")
    private Long connectionsId;

    @Column(name = "status", nullable = false)
    private boolean status = false; // Initial status set to false

    @Column(name = "studentId", nullable = false)
    private Long studentId;

    @ManyToOne
    @JoinColumn(name = "connectionId", referencedColumnName = "studentId")
    private StudentEntity connection;

}
