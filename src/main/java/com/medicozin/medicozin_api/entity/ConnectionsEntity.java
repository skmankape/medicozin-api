package com.medicozin.medicozin_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Connections")
public class ConnectionsEntity {
    @Id
    @GeneratedValue
    @Column(name = "connectionsId")
    private Long connectionsId;

    private String status;

    private Long studentId;

    @ManyToOne
    @JoinColumn(name = "connectionId", referencedColumnName = "studentId")
    private StudentEntity connection;


}
