package com.wipro.ecom.user.security;

import com.wipro.ecom.user.entity.User;
import com.wipro.ecom.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;


    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = repo.findByUserId(userId)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String authority = user.getUserType() == 0 ? "ROLE_ADMIN" : "ROLE_USER";

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserId())
                .password(user.getPassWord())  
                .authorities(authority)
                .build();
    }
}
