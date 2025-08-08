package com.wipro.orderms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients  
//@EnableConfigServer
public class OrdermsApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrdermsApplication.class, args);
    }
}
