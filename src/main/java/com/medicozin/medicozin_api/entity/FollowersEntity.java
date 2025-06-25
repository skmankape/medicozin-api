package com.medicozin.medicozin_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Followers")
public class FollowersEntity {

    @Id
    @GeneratedValue
    @Column(name = "folloersId")
    private UUID folloersId;

    private UUID studentId;
    @ManyToOne
    @JoinColumn(name = "followeruserid", referencedColumnName = "studentId")
    private StudentEntity follower;


}
