package com.medicozin.medicozin_api.service;

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


@Service
public class StudentService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    public StudentEntity findByEmail(String email) {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

    public void saveStudent(StudentEntity student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new UsernameAlreadyExistsException("Email already exists: " + student.getEmail());
        }
        if (companyRepository.existsByEmail(student.getEmail())) {
            throw new UsernameAlreadyExistsException("Email already exists: " + student.getEmail());
        }
        if (doctorRepository.existsByEmail(student.getEmail())) {
            throw new UsernameAlreadyExistsException("Email already exists: " + student.getEmail());
        }
        studentRepository.save(student);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
    public Optional<StudentEntity> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public StudentEntity findById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }
}
