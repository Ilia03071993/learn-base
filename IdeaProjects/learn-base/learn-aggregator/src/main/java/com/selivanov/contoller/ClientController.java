package com.selivanov.contoller;

import com.selivanov.dto.StudentDto;
import com.selivanov.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {
    private static final String STRING_TOPIC = "kafka-string-topic";

    public final ClientService clientService;

//    @GetMapping("/{name}")
//    public ResponseEntity<StudentDto> getStudentByName(@PathVariable("name") String name) {
//        return ResponseEntity.ok(clientService.getStudentByName(name));
//    }

    @KafkaListener(topics = STRING_TOPIC)
    public void getStudentByNameAsync(StudentDto studentDto) {
        clientService.getStudentByNameAsync(studentDto);
        log.info("Message get to topic");
    }
}