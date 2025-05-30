package com.selivanov.client;

import com.selivanov.model.StudentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StudentClient {
    private final KafkaTemplate<Integer, StudentDto> kafkaTemplate;

    @Value("${kafka.topics.student-response}")
    private String studentTopic;

    public void sendStudent(StudentDto student) {
        kafkaTemplate.send(studentTopic, student);
        log.info("Message sent to KafkaConsumer in topic" + studentTopic);
    }
}
