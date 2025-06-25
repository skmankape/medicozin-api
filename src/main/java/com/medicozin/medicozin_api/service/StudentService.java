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
    public Optional<StudentEntity> getStudentById(UUID studentId) {
        return studentRepository.findById(studentId);
    }

    public Optional<Object[]> getStudentDetailsByUserId(UUID userId) {
        return studentRepository.findStudentDetailsByUserId(userId);
    }

    public StudentEntity findById(UUID studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public void updateStudentDetails(UUID userId, StudentEntity updatedStudent) {
        StudentEntity existingStudent = studentRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Update allowed fields only
        existingStudent.setGender(updatedStudent.getGender());
        existingStudent.setDob(updatedStudent.getDob());
        existingStudent.setLocation(updatedStudent.getLocation());
        existingStudent.setYear(updatedStudent.getYear());
        existingStudent.setMobileno(updatedStudent.getMobileno());

        studentRepository.save(existingStudent);
    }
}
