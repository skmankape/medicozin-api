package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.CompanyEntity;
import com.medicozin.medicozin_api.entity.DoctorEntity;
import com.medicozin.medicozin_api.entity.StudentEntity;
import com.medicozin.medicozin_api.repository.CompanyRepository;
import com.medicozin.medicozin_api.repository.DoctorRepository;
import com.medicozin.medicozin_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            StudentEntity student = studentRepository.findByEmail(email)
                    .orElse(null);
            if (student != null) {
                return student;
            }

            DoctorEntity doctor = doctorRepository.findByEmail(email)
                    .orElse(null);
            if (doctor != null) {
                return doctor;
            }

            CompanyEntity company = companyRepository.findByEmail(email)
                    .orElse(null);
            if (company != null) {
                return company;
            }

            throw new UsernameNotFoundException("User not found with email: " + email);
        } catch (Exception e) {
            throw new UsernameNotFoundException("Internal error occurred while loading user by username", e);
        }
    }
}
