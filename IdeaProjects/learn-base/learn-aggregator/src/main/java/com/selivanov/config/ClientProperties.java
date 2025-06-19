package com.selivanov.config;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@Data
@ConfigurationProperties(prefix = "clients")
public class ClientProperties {
    @NotBlank
    private String university;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}