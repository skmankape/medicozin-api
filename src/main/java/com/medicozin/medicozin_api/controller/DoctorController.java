package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.DoctorEntity;
import com.medicozin.medicozin_api.entity.StudentEntity;
import com.medicozin.medicozin_api.service.DoctorService;
import com.medicozin.medicozin_api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/doctorDetails/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable UUID id) {
        Optional<DoctorEntity> doctor = doctorService.getDoctorById(id);
        if (doctor.isPresent()) {
            return ResponseEntity.ok(doctor.get());
        } else {
            return ResponseEntity.status(404).body("Doctor not found");
        }
    }

    @GetMapping("/doctorAddress/{userId}")
    public ResponseEntity<Object[]> getDoctorDetailsByUserId(@PathVariable UUID userId) {
        Optional<Object[]> doctorDetails = doctorService.getDoctorDetailsByUserId(userId);
        return doctorDetails.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/doctorUpdate/{id}")
    public ResponseEntity<?> updateDoctorDetails(@PathVariable("id") UUID userId, @RequestBody DoctorEntity doctor) {
        try {
            doctorService.updateDoctorDetails(userId, doctor);
            return ResponseEntity.ok("Doctor updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update failed: " + e.getMessage());
        }
    }



}
