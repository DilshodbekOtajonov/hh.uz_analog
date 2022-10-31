package com.example.project_blueprint;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableCaching
@OpenAPIDefinition
public class ProjectBlueprintApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectBlueprintApplication.class, args);
    }
}
