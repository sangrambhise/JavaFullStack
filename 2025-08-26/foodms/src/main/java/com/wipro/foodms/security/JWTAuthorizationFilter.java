package com.wipro.foodms.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;
import java.security.Key;
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";
    private static final Key SECRET = Keys.hmacShaKeyFor(System.getenv("JWT_SECRET").getBytes());
//    private static final String SECRET = "d3No4uat7HEgU6RHjJ902G+gTj3+qHNZZ/CN6BUeCa4cKFSkp1AGFXH7ODj3A+fPDf1WQB2x6Yknr6VFh5ySyw==";
//    private static final String SECRET = System.getenv("jwt.secret"); 
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

        String header = request.getHeader(HEADER);
        if (header == null || !header.startsWith(PREFIX)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Token is missing or invalid.");
            return;
        }


        try {
        	String token = header.replace(PREFIX, "");
        	System.out.println("Token: " + token);
        	Claims claims = Jwts.parserBuilder()
                    .setSigningKey(SECRET)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            System.out.println("Claims: " + claims);
            List<String> authorities = (List<String>) claims.get("authorities");
            chain.doFilter(request, response);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Invalid token"+ e.getMessage());
            e.printStackTrace();
        }
    }
}
