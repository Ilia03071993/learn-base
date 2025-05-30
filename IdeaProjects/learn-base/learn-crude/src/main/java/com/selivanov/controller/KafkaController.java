package com.selivanov.controller;

import com.selivanov.model.StudentDto;
import com.selivanov.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaController {
    private final StudentService studentService;

    @KafkaListener(topics = "${kafka.topics.student-request}")
    @Transactional
    public void consumeStudentResult(StudentDto studentDto) {
        studentService.sendStudent(studentDto);
    }
}