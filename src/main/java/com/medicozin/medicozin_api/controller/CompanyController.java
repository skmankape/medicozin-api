package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.CompanyEntity;
import com.medicozin.medicozin_api.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController

public class CompanyController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CompanyService companyService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/ccreate")
    public ResponseEntity<?> createCompany(@RequestBody CompanyEntity company) {
        company.setPassword(passwordEncoder.encode(company.getPassword()));
        companyService.saveCompany(company);
        return ResponseEntity.ok("Company registered successfully");
    }


}
