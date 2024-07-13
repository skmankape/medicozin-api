package com.medicozin.medicozin_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Doctor")
public class DoctorEntity implements UserDetails {
    @Id
    @GeneratedValue
    @Column(name="doctorid")
    private Long doctorid;
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


    public Long getDoctorId() {
        return doctorid;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorid = doctorId;
    }


}
