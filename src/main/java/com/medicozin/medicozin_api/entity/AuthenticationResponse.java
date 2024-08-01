
package com.medicozin.medicozin_api.entity;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private final String jwt;
    private final Long userId;
    private final String userType;

    public AuthenticationResponse(String jwt, Long userId, String userType) {
        this.jwt = jwt;
        this.userId = userId;
        this.userType = userType;
    }

    public String getJwt() {
        return jwt;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserType() {
        return userType;
    }
}
