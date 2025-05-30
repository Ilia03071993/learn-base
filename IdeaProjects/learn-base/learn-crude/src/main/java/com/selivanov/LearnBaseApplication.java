package com.selivanov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class LearnBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnBaseApplication.class, args);
    }
}