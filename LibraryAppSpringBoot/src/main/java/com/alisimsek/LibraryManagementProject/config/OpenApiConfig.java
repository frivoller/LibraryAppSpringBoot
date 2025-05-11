package com.alisimsek.LibraryManagementProject.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Server httpsServer = new Server()
                .url("https://advisory-slug-frivoller-95937079.koyeb.app")
                .description("HTTPS Server");

        return new OpenAPI()
                .servers(Arrays.asList(httpsServer))
                .info(new Info()
                        .title("Kütüphane Yönetim API")
                        .version("1.0")
                        .description("Kütüphane Yönetim Sistemi API'si")
                        .license(new License().name("MIT License")))
                .components(new Components()
                        .addSecuritySchemes("bearer-key", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
} 