package com.selivanov.controller;

import com.selivanov.dto.StudentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaController {

    @KafkaListener(topics = "${kafka.topics.student-response}")
    public void consumeStudentResult(StudentDto studentDto) {
        log.info("Received student from consumer: name - {}, courses - {}.",
                studentDto.name(),
                studentDto.courses()
        );
    }
}
