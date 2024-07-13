package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.*;
import com.medicozin.medicozin_api.service.CompanyService;
import com.medicozin.medicozin_api.service.DoctorService;
import com.medicozin.medicozin_api.service.StudentService;
import com.medicozin.medicozin_api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StudentService studentService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/hello")
    public String firstPage() {
        return "Hello Venky";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }

        UserDetails userDetails = null;
        String jwt = null;
        Long userId = null;
        String userType = authenticationRequest.getUserType();

        if ("student".equals(userType)) {
            userDetails = studentService.loadUserByUsername(authenticationRequest.getUsername());
            jwt = jwtUtil.generateToken(userDetails);
            StudentEntity student = studentService.findByEmail(authenticationRequest.getUsername());
            userId = student.getStudentId();

        } else if ("doctor".equals(userType)) {
            userDetails = doctorService.loadUserByUsername(authenticationRequest.getUsername());
            jwt = jwtUtil.generateToken(userDetails);
            DoctorEntity doctor = doctorService.findByEmail(authenticationRequest.getUsername());
            userId = doctor.getDoctorId();
        } else if ("company".equals(userType)) {
            userDetails = companyService.loadUserByUsername(authenticationRequest.getUsername());
            jwt = jwtUtil.generateToken(userDetails);
            CompanyEntity company = companyService.findByEmail(authenticationRequest.getUsername());
            userId = company.getCompanyid();
        } else {
            throw new Exception("Invalid user type");
        }

        AuthenticationResponse response = new AuthenticationResponse(jwt, Math.toIntExact(userId), userType);
        return ResponseEntity.ok(response);
    }
}