package com.selivanov.client;

import com.selivanov.config.ClientProperties;
import com.selivanov.model.auth.AuthRequest;
import com.selivanov.model.auth.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Component
@RequiredArgsConstructor
public class AuthClient {
    private final ClientProperties clientProperties;
    private final RestTemplateBuilder restTemplateBuilder;

    public AuthResponse getToken() {
        RestTemplate restTemplate = restTemplateBuilder
                .uriTemplateHandler(new DefaultUriBuilderFactory(clientProperties.getUniversity()))
                .build();

        return restTemplate.postForObject(
                "/login",
                new AuthRequest(clientProperties.getUsername(), clientProperties.getPassword()),
                AuthResponse.class
        );
    }
}
