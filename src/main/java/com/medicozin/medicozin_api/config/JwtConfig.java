package com.medicozin.medicozin_api.config;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
public class JwtConfig {

    @Bean
    public SecretKey secretKey() {
        // Generate a secure key for HS256 algorithm
        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }
}
