package com.wipro.ecom.user.config;

import com.wipro.ecom.user.entity.User;
import com.wipro.ecom.user.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String adminUserId = "mahesh";
            if (userRepository.findByUserId(adminUserId).isEmpty()) {
                User admin = new User();
                admin.setAddress("Admin Address");
                admin.setUserId(adminUserId);
                admin.setEmailId("mahesh@gmail.com");
                admin.setFirstName("System");
                admin.setLastName("Admin");
                admin.setPassWord(passwordEncoder.encode("admin123")); 
                admin.setUserType(0); 

                userRepository.save(admin);
                System.out.println("Default admin created: userId=admin, password=admin123");
            } else {
                System.out.println("Admin already exists, skipping creation.");
            }
        };
    }
}
