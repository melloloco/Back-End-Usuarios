package com.pizzeria.pizzeria.core.ConfigurationBeans;

import java.sql.Date;
import java.util.UUID;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtils {
    public static String getJWTToken(UUID userId) {
        String secretKey = System.getenv("Key");
        String token = Jwts
                .builder()
                .setId(userId.toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes())
                .compact();
        return token;
    }
}
