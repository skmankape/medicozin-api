
package com.medicozin.medicozin_api.entity;

import java.io.Serializable;
import java.util.UUID;

public class AuthenticationResponse implements Serializable {

    private final String jwt;
    private final UUID userId;
    private final String userType;

    public AuthenticationResponse(String jwt, UUID userId, String userType) {
        this.jwt = jwt;
        this.userId = userId;
        this.userType = userType;
    }

    public String getJwt() {
        return jwt;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUserType() {
        return userType;
    }
}
