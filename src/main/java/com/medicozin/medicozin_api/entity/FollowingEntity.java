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

    private Long studentId;

    @ManyToOne
    @JoinColumn(name = "foloowinguserid", referencedColumnName = "studentId")
    private StudentEntity following;

}
