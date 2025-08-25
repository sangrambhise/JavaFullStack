package com.wipro.foodms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FoodmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodmsApplication.class, args);
	}

}
