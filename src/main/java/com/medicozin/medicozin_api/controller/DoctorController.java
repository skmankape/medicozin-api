package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.DoctorEntity;
import com.medicozin.medicozin_api.service.DoctorService;
import com.medicozin.medicozin_api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class DoctorController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/doctorRegister")
    public ResponseEntity<?> createDoctor(@RequestBody DoctorEntity doctor) {
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        doctorService.saveDoctor(doctor);
        return ResponseEntity.ok("Doctor registered successfully");
    }


}
