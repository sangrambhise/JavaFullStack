package com.wipro.usermgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Usermgmtv2Application {

	public static void main(String[] args) {
		SpringApplication.run(Usermgmtv2Application.class, args);
	}

}
