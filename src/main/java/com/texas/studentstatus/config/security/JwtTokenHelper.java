package com.texas.studentstatus.config.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenHelper {
    public final static long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    private final String secret = "jwtTokenKey";
}
