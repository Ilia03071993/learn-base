package com.selivanov.contoller;

import com.selivanov.dto.StudentDto;
import com.selivanov.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {

    private final KafkaTemplate<Integer, StudentDto> kafkaTemplate;
    @Value("${kafka.topics.student-response}")
    private String studentResponseTopic;
    public final ClientService clientService;

//    @GetMapping("/{name}")
//    public ResponseEntity<StudentDto> getStudentByName(@PathVariable("name") String name) {
//        return ResponseEntity.ok(clientService.getStudentByName(name));
//    }

    @KafkaListener(topics = "${kafka.topics.student-request}")
    public void getStudentByNameAsyncFromProducer(StudentDto studentDto) {
        log.info("Consumed from producer: " + studentDto.name());
        clientService.getStudentByNameAsync(studentDto);

        kafkaTemplate.send(studentResponseTopic, studentDto);
    }
}