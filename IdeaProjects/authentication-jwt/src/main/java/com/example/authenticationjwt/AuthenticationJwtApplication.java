package com.example.authenticationjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class AuthenticationJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationJwtApplication.class, args);
    }

}
