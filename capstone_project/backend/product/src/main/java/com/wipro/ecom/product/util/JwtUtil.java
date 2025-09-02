package com.wipro.ecom.product.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;

@Component
public class JwtUtil {

  private final Key key;
  private final long expirationMs;

  public JwtUtil(
      @Value("${jwt.secret}") String secret,
      @Value("${jwt.expiration}") long expirationMs) {
    this.key = Keys.hmacShaKeyFor(secret.getBytes());
    this.expirationMs = expirationMs;
  }

  public String generateToken(String username, List<String> roles) {
    Date now = new Date();
    Date exp = new Date(now.getTime() + expirationMs);
    return Jwts.builder()
        .setSubject(username)
        .claim("roles", roles)
        .setIssuedAt(now)
        .setExpiration(exp)
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
  }

  public String extractUsername(String token) {
    Claims claims = parseClaims(token);
    return claims == null ? null : claims.getSubject();
  }

  public List<String> extractRoles(String token) {
    Claims claims = parseClaims(token);
    if (claims == null) return Collections.emptyList();
    Object rolesObj = claims.get("roles");
    if (rolesObj instanceof List) {
      @SuppressWarnings("unchecked")
      List<Object> raw = (List<Object>) rolesObj;
      List<String> roles = new ArrayList<>();
      for (Object o : raw) roles.add(o.toString());
      return roles;
    } else if (rolesObj instanceof String) {
      String s = (String) rolesObj;
      return Arrays.asList(s.split(","));
    }
    return Collections.emptyList();
  }

  public boolean validateToken(String token) {
    try {
      Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      Date exp = claims.getBody().getExpiration();
      return exp == null || exp.after(new Date());
    } catch (JwtException | IllegalArgumentException e) {
      return false;
    }
  }

  private Claims parseClaims(String token) {
    try {
      return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    } catch (JwtException | IllegalArgumentException e) {
      return null;
    }
  }
}
