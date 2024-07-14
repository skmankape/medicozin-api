package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.CompanyEntity;
import com.medicozin.medicozin_api.entity.StudentEntity;
import com.medicozin.medicozin_api.exception.UsernameAlreadyExistsException;
import com.medicozin.medicozin_api.repository.CompanyRepository;
import com.medicozin.medicozin_api.repository.DoctorRepository;
import com.medicozin.medicozin_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements UserDetailsService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private StudentRepository studentRepository;

    public CompanyEntity findByEmail(String email) {
        return companyRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Company not found with email: " + email));
    }

    public void saveCompany(CompanyEntity company) {
        if (companyRepository.existsByEmail(company.getEmail())) {
            throw new UsernameAlreadyExistsException("Email already exists: " + company.getEmail());
        }
        if (doctorRepository.existsByEmail(company.getEmail())) {
            throw new UsernameAlreadyExistsException("Email already exists: " + company.getEmail());
        }
        if (studentRepository.existsByEmail(company.getEmail())) {
            throw new UsernameAlreadyExistsException("Email already exists: " + company.getEmail());
        }
        companyRepository.save(company);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return companyRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Company not found with email: " + email));
    }
}
