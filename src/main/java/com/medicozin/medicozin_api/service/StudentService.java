package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.StudentEntity;
import com.medicozin.medicozin_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

    public StudentEntity findByEmail(String email) {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

    public void saveStudent(StudentEntity student) {
        studentRepository.save(student);
    }
}
