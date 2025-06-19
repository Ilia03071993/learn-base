package com.selivanov.client;

import com.selivanov.model.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class StudentClient {
    private final RestTemplate restTemplateJwt;

    // local -> dev -> int/stage -> prod
    public StudentDto getStudentByName(String name) {
        return restTemplateJwt.getForObject(
                "/api/students/name/%s".formatted(name),
                StudentDto.class
        );
    }
}