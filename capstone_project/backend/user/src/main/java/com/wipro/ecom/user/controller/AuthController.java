package com.wipro.ecom.user.controller;

import com.wipro.ecom.user.dto.LoginRequest;
import com.wipro.ecom.user.dto.LoginResponse;
import com.wipro.ecom.user.dto.UserDTO;
import com.wipro.ecom.user.entity.User;
import com.wipro.ecom.user.service.RevokedTokenService;
import com.wipro.ecom.user.service.UserService;
import com.wipro.ecom.user.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
    @Autowired
    private AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final RevokedTokenService revokedTokenService; // optional if you track revoked tokens

    public AuthController(JwtUtil jwtUtil, RevokedTokenService revokedTokenService) {
        this.jwtUtil = jwtUtil;
        this.revokedTokenService = revokedTokenService;
    };
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> register(@RequestBody UserDTO dto) {
        userService.register(dto); 
        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully!");
        return ResponseEntity.ok(response);    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest req) throws AuthenticationException {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(req.getUserId(), req.getPassword())
        );
        User user = userService.findByUsername(req.getUserId());
        String token = jwtUtil.generateToken(req.getUserId());
        String role = user.getUserType() == 0 ? "ROLE_ADMIN" : "ROLE_USER";

        return new LoginResponse(token,role);
    }
    
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("No token provided");
        }

        String token = header.substring(7);
        revokedTokenService.revokeToken(token);

        return ResponseEntity.ok("Logged out successfully");
    }

    
}
