package com.libreria.v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Librería V1")
                        .version("1.0")
                        .description("Documentación generada con Springdoc OpenAPI")
                        .contact(new Contact()
                                .name("Libreria")
                                .email("soporte@libreria.com")
                        )
                );
    }
}

