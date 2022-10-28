package com.example.project_blueprint;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.nio.charset.Charset;
import java.util.Random;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableCaching(proxyTargetClass = true)
public class ProjectBlueprintApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectBlueprintApplication.class, args);
    }

}

