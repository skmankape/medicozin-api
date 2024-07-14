package com.medicozin.medicozin_api.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private String email;
    private String password;
    private boolean active;

    public MyUserDetails(UserDetails userDetails) {
        this.email = userDetails.getUsername();
        this.password = userDetails.getPassword();
        this.active = userDetails.isEnabled();
    }

    public MyUserDetails(StudentEntity student) {
        this.email = student.getEmail();
        this.password = student.getPassword();
        this.active = student.isActive();
    }

    public MyUserDetails(DoctorEntity doctor) {
        this.email = doctor.getEmail();
        this.password = doctor.getPassword();
        this.active = doctor.isActive();
    }

    public MyUserDetails(CompanyEntity company) {
        this.email = company.getEmail();
        this.password = company.getPassword();
        this.active = company.isActive();
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
