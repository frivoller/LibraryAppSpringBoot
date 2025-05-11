package com.alisimsek.LibraryManagementProject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GlobalOpenApiCustomizer serverCustomizer() {
        return openApi -> {
            // Tüm mevcut serverları temizle
            openApi.servers(new ArrayList<>());
            // Sadece HTTPS server ekle
            Server httpsServer = new Server();
            httpsServer.setUrl("https://advisory-slug-frivoller-95937079.koyeb.app");
            httpsServer.setDescription("HTTPS Server");
            openApi.addServersItem(httpsServer);
        };
    }
} 