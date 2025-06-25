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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Company")
public class CompanyEntity implements UserDetails {
    @Id
    @GeneratedValue
    @Column(name = "companyid")
    private UUID companyid;

    @Column(name = "cname")
    private String cname;

    @Column(name = "email")
    private String email;

    @Column(name = "mobileno")
    private String mobileno;

    @Column(name = "password")
    private String password;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }


    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }


    public boolean isAccountNonExpired() {
        return true;
    }
    public boolean isActive() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }


    public boolean isCredentialsNonExpired() {
        return true;
    }

    public UUID getId() {
        return companyid;
    }

    public boolean isEnabled() {
        return true;
    }
}
