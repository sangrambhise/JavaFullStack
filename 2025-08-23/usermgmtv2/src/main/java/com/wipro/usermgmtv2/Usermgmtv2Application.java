package com.wipro.usermgmtv2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@EnableDiscoveryClient
public class Usermgmtv2Application {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public static void main(String[] args) {
        SpringApplication.run(Usermgmtv2Application.class, args);
//        System.out.println("JWT Secret: " + jwtSecret);
    }
}
