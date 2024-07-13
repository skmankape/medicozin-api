package com.medicozin.medicozin_api.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;

@Service
public class JwtService {

    private final SecretKey secretKey;

    @Autowired
    public JwtService(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    // Other JWT operations...
}
