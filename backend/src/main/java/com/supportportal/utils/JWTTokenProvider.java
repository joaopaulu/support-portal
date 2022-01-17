package com.supportportal.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.supportportal.entities.UserPrincipal;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

import static com.supportportal.constant.SecurityConstant.*;

public class JWTTokenProvider {
    @Value("jwt.secret")
    private String secret;

    public String generateJwtToken(UserPrincipal userPrincipal){
        String[] claims = getClaimsFromUser(userPrincipal);
        return JWT.create().withIssuer(GET_ARRAYS_LLC).withAudience(GET_ARRAYS_ADMINISTRATION)
                .withIssuedAt(new Date()).withSubject(userPrincipal.getUsername())
                .withArrayClaim(AUTHORITIES, claims).withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(secret.getBytes()));
    }

    public String[] getClaimsFromUser(UserPrincipal userPrincipal){
        return null;
    }
}
