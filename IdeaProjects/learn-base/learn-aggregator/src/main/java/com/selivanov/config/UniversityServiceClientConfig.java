package com.selivanov.config;

import com.selivanov.client.AuthClient;
import com.selivanov.config.jwt.JwtRestTemplateInterceptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;


@Configuration
@EnableConfigurationProperties(ClientProperties.class)
public class UniversityServiceClientConfig {

    @Bean
    public JwtRestTemplateInterceptor jwtRestTemplateInterceptor(AuthClient authClient) {
        return new JwtRestTemplateInterceptor(authClient);
    }

    @Bean
    public RestTemplate restTemplateJwt(ClientProperties clientProperties,
                                        JwtRestTemplateInterceptor jwtInterceptor,
                                        RestTemplateBuilder builder) {
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(clientProperties.getUniversity());
        return builder
                .interceptors(jwtInterceptor)
                .uriTemplateHandler(uriBuilderFactory)
                .build();
    }

    @Bean
    public RestTemplate restTemplatePlain(ClientProperties clientProperties,
                                          RestTemplateBuilder builder) {
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(clientProperties.getUniversity());
        return builder
                .uriTemplateHandler(uriBuilderFactory)
                .build();
    }
}