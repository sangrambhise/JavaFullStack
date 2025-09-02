package com.wipro.ecom.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(
        title = "E-Commerce API",
        version = "1.0",
        description = "APIs for Product, Order, Cart and User services"
    )
)
@Configuration
public class OpenApiConfig {
}
