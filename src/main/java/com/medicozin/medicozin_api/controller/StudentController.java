package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.AuthenticationRequest;
import com.medicozin.medicozin_api.entity.AuthenticationResponse;
import com.medicozin.medicozin_api.entity.StudentEntity;
import com.medicozin.medicozin_api.service.StudentService;
import com.medicozin.medicozin_api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

@CrossOrigin(origins = "http://localhost:8081")
public class StudentController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StudentService studentService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/studentRegister")
    public ResponseEntity<?> registerStudent(@RequestBody StudentEntity student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentService.saveStudent(student);
        return ResponseEntity.ok("Student registered successfully");
    }
    @GetMapping("/studentDetails/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        Optional<StudentEntity> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.status(404).body("Student not found");
        }
    }

}
