package com.wipro.ecom.order.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers(
                            "/swagger-ui.html",
                            "/swagger-ui/**",
                            "/v3/api-docs/**",
                            "/swagger-resources/**",
                            "/webjars/**"
                    ).permitAll()
                .requestMatchers(HttpMethod.GET, "/order/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/cart/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/order/**").authenticated()
                .requestMatchers(HttpMethod.POST, "/cart/**").authenticated()
                .requestMatchers(HttpMethod.PUT, "/order/**").authenticated()
                .requestMatchers(HttpMethod.PUT, "/cart/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/order/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/cart/**").authenticated()

                .anyRequest().permitAll()
            );

        return http.build();
    }
}
