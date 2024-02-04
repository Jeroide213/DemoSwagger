package com.example.DemoSwagger.Swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info().title("Api REST MySQL").version("1.0 SNAPSHOT")
                .contact(new Contact().name("Jeronimo").url("https://twitter.com/Jero_701").email("jeronimo.jalef@gmail.com"))
                .description("Api encargada de realizar peticiones a una base de datos de Alumnos y Profesores."));
    }
}