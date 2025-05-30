package com.selivanov.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class ClientConfig {
//    @Value("${clients.student}")
    private String studentBaseUrl = "http://localhost:8080/api/students";

    @Bean
    public RestTemplate studentRestTemplate(RestTemplateBuilder builder) {
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(studentBaseUrl);
        return builder
                .uriTemplateHandler(uriBuilderFactory)
                .build();
    }
}