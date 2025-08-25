package com.wipro.usermgmtv2.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import com.wipro.usermgmtv2.entity.User;
import java.security.Key;

public class JwtUtil {

    private static final Key SECRET_KEY = Keys.hmacShaKeyFor(System.getenv("JWT_SECRET").getBytes());
    public static String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SECRET_KEY)
                .compact();
    }

    public static Claims extractClaims(String token) {
        return Jwts.parserBuilder()  // Updated to parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public static String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public static boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public static boolean validateToken(String token, User user) {
        return (user.getEmail().equals(extractUsername(token)) && !isTokenExpired(token));
    }
}
