package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.CompanyEntity;
import com.medicozin.medicozin_api.entity.DoctorEntity;
import com.medicozin.medicozin_api.entity.MyUserDetails;
import com.medicozin.medicozin_api.entity.StudentEntity;
import com.medicozin.medicozin_api.repository.CompanyRepository;
import com.medicozin.medicozin_api.repository.DoctorRepository;
import com.medicozin.medicozin_api.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<StudentEntity> student = studentRepository.findByEmail(email);
        if (student.isPresent()) {
            logger.debug("Student found: {}", email);
            return student.map(MyUserDetails::new).orElseThrow();
        }

        Optional<DoctorEntity> doctor = doctorRepository.findByEmail(email);
        if (doctor.isPresent()) {
            logger.debug("Doctor found: {}", email);
            return doctor.map(MyUserDetails::new).orElseThrow();
        }

        Optional<CompanyEntity> company = companyRepository.findByEmail(email);
        if (company.isPresent()) {
            logger.debug("Company found: {}", email);
            return company.map(MyUserDetails::new).orElseThrow();
        }

        logger.debug("User not found: {}", email);
        throw new UsernameNotFoundException("User not found with email: " + email);
    }

    public boolean isStudentUser(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }

    public boolean isDoctorUser(String email) {
        return doctorRepository.findByEmail(email).isPresent();
    }

    public boolean isCompanyUser(String email) {
        return companyRepository.findByEmail(email).isPresent();
    }
}
