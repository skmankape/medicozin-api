package com.medicozin.medicozin_api.controller;

import com.medicozin.medicozin_api.entity.AuthenticationRequest;
import com.medicozin.medicozin_api.entity.AuthenticationResponse;
import com.medicozin.medicozin_api.entity.MyUserDetails;
import com.medicozin.medicozin_api.service.MyUserDetailsService;
import com.medicozin.medicozin_api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @RequestMapping("/hello")
    public String firstPage() {
        return "Hello World";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final MyUserDetails userDetails = (MyUserDetails) userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        String userType;
        if (userDetailsService.isStudentUser(authenticationRequest.getUsername())) {
            userType = "student";
        } else if (userDetailsService.isDoctorUser(authenticationRequest.getUsername())) {
            userType = "doctor";
        } else if (userDetailsService.isCompanyUser(authenticationRequest.getUsername())) {
            userType = "company";
        } else {
            throw new Exception("Unknown user type");
        }

        return ResponseEntity.ok(new AuthenticationResponse(jwt, userDetails.getUserId(), userType));
    }
}
