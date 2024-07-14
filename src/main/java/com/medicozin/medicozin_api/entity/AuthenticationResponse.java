package com.medicozin.medicozin_api.entity;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private final String jwt;
    private final String email;
    private final String userType;

    public AuthenticationResponse(String jwt, String email, String userType) {
        this.jwt = jwt;
        this.email = email;
        this.userType = userType;
    }

    public String getJwt() {
        return jwt;
    }

    public String getUsername() {
        return email;
    }

    public String getUserType() {
        return userType;
    }
}
