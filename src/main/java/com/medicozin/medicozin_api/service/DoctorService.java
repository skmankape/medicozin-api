package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.DoctorEntity;
import com.medicozin.medicozin_api.entity.StudentEntity;
import com.medicozin.medicozin_api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DoctorService implements org.springframework.security.core.userdetails.UserDetailsService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return  doctorRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Doctor not found with email: " + email));
    }



    public void saveDoctor(DoctorEntity doctor) {
        doctorRepository.save(doctor);

    }

    public DoctorEntity findByEmail(String email) {
        return doctorRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }
}
