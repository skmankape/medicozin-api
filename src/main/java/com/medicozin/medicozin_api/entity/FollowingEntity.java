package com.medicozin.medicozin_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Following")
public class FollowingEntity {
    @Id
    @GeneratedValue
    @Column(name = "followingid")
    private Long followingid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "collagename")
    private String collagename;

    @Column(name = "followinguserid")
    private String followinguserid;

}
