package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.DoctorEntity;
import com.medicozin.medicozin_api.entity.StudentEntity;
import com.medicozin.medicozin_api.exception.UsernameAlreadyExistsException;
import com.medicozin.medicozin_api.repository.CompanyRepository;
import com.medicozin.medicozin_api.repository.DoctorRepository;
import com.medicozin.medicozin_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class DoctorService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private StudentRepository studentRepository;

    public DoctorEntity findByEmail(String email) {
        return doctorRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Doctor not found with email: " + email));
    }

    public Optional<DoctorEntity> getDoctorById(UUID doctorId) {
        return doctorRepository.findById(doctorId);
    }

    public Optional<Object[]> getDoctorDetailsByUserId(UUID userId) {
        return doctorRepository.findDoctorDetailsByUserId(userId);
    }


    public void saveDoctor(DoctorEntity doctor) {
        if (doctorRepository.existsByEmail(doctor.getEmail())) {
            throw new UsernameAlreadyExistsException("Email already exists: " + doctor.getEmail());
        }
        if (companyRepository.existsByEmail(doctor.getEmail())) {
            throw new UsernameAlreadyExistsException("Email already exists: " + doctor.getEmail());
        }
        if (studentRepository.existsByEmail(doctor.getEmail())) {
            throw new UsernameAlreadyExistsException("Email already exists: " + doctor.getEmail());
        }
        doctorRepository.save(doctor);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return doctorRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Doctor not found with email: " + email));
    }

    public void updateDoctorDetails(UUID userId, DoctorEntity updatedDoctor) {
        DoctorEntity existingDoctor = doctorRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        // Update allowed fields only
        existingDoctor.setGender(updatedDoctor.getGender());
        existingDoctor.setDob(updatedDoctor.getDob());
        existingDoctor.setLocation(updatedDoctor.getLocation());
        existingDoctor.setYear(updatedDoctor.getYear());
        existingDoctor.setMobileno(updatedDoctor.getMobileno());

        doctorRepository.save(existingDoctor);
    }

}
