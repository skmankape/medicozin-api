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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Doctor")
public class DoctorEntity implements UserDetails {
    @Id
    @GeneratedValue
    @Column(name="doctorid")
    private UUID doctorid;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="collagename")
    private String collagename;
    @Column(name="email")
    private String email;
    @Column(name="designation")
    private String designation;
    @Column(name="specialization")
    private String specialization;
    //SHREE//
    @Column(name = "gender")
    private String gender;

    @Column(name = "location")
    private String location;

    @Column(name = "year")
    private String year;

    @Column(name = "dob")
    private String dob;
    //SHREE//

    @Column(name="mobileno")
    private String mobileno;
    @Column(name="password")
    private String password;
    @Column(name="referralcode")
    private String referralcode;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UUID getId() {
        return doctorid;
    }

    public UUID getDoctorId() {
        return doctorid;
    }
    public boolean isActive() {
        return true;
    }
    public void setDoctorId(UUID doctorId) {
        this.doctorid = doctorId;
    }


}
