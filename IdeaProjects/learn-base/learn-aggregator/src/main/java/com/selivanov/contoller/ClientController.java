package com.selivanov.contoller;

import com.selivanov.model.StudentDto;
import com.selivanov.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {
    public final ClientService clientService;
    private final KafkaTemplate<Integer, StudentDto> kafkaTemplate;

    @Value("${kafka.topics.student-request}")
    private String studentRequestTopic;

    @GetMapping("/{name}")
    public ResponseEntity<StudentDto> getStudentByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(clientService.getStudentByName(name));
    }

    @GetMapping("/{name}/async")
    public ResponseEntity<Void> requestStudentByNameAsync(@PathVariable("name") String name) {
        StudentDto student = new StudentDto(null, name, null);
        kafkaTemplate.send(studentRequestTopic, student);
        log.info("Message sent to KafkaProducer in topic" + studentRequestTopic);
        return ResponseEntity.ok().build();
    }

    @KafkaListener(topics = "${kafka.topics.student-response}")
    public void getStudentByNameAsyncFromProducer(StudentDto studentDto) {
        log.info("Consumed from producer: " + studentDto.name());
        clientService.consumeStudentResponse(studentDto);
    }
}