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

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;


    @Column(name = "email")
    private String email;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "collagename")
    private String collagename;


    @Column(name = "connectionuserid")
    private String connectionuserid;
}
