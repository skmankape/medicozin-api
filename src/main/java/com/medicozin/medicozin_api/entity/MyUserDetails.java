package com.medicozin.medicozin_api.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class MyUserDetails implements UserDetails {

    private UUID userId;
    private String email;
    private String password;
    private boolean active;

    public MyUserDetails(UserDetails userDetails, UUID userId) {
        this.email = userDetails.getUsername();
        this.password = userDetails.getPassword();
        this.active = userDetails.isEnabled();
        this.userId = userId;
    }

    public MyUserDetails(StudentEntity student) {
        this.email = student.getEmail();
        this.password = student.getPassword();
        this.active = student.isActive();
        this.userId = student.getId();
    }

    public MyUserDetails(DoctorEntity doctor) {
        this.email = doctor.getEmail();
        this.password = doctor.getPassword();
        this.active = doctor.isActive();
        this.userId = doctor.getId();
    }

    public MyUserDetails(CompanyEntity company) {
        this.email = company.getEmail();
        this.password = company.getPassword();
        this.active = company.isActive();
        this.userId = company.getId();
    }

    public UUID getUserId() {
        return userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
        return active;
    }
}
