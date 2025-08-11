package com.wipro.jwtDemo.controller;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import com.wipro.jwtDemo.dto.User;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/login")
    public User login(@RequestParam("username") String username, @RequestParam("password") String pwd) {
        if (!"admin".equals(username) || !"password".equals(pwd)) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = getJWTToken(username);
        User user = new User();
        user.setUsername(username);
        user.setToken(token);
        return user;
    }

    private static final String SECRET = "mySuperSecretKeyThatIsAtLeast32Characters";

    private String getJWTToken(String username) {
        Key key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        return Jwts.builder()
                .setId("jwtExample")
                .setSubject(username)
                .claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 60000))
                .signWith(key)
                .compact();
    }

}
