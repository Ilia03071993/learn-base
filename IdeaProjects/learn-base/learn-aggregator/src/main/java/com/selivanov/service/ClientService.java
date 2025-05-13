package com.selivanov.service;

import com.selivanov.dto.StudentDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ClientService {
    public StudentDto getStudentByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/api/students/name/%s".formatted(name),
                StudentDto.class);
    }

    public void getStudentByNameAsync(StudentDto studentDto) {
        System.out.println("name: " + studentDto.name() + ", courses: " + studentDto.courses());
    }
}
