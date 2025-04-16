package com.selivanov.controller;

import com.selivanov.dto.PassportDto;
import com.selivanov.dto.PersonDto;
import com.selivanov.dto.PersonPassportRequest;
import com.selivanov.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;

    @GetMapping()
    public ResponseEntity<PersonDto> getPerson(@RequestBody PersonDto personDto) {
        PersonDto person = service.getPerson(personDto);

        return ResponseEntity.ok(person);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonDto>> getPersons() {
        List<PersonDto> persons = service.getPersons();

        return ResponseEntity.ok(persons);
    }

    @GetMapping("/passport")
    public ResponseEntity<PassportDto> getPassportByPerson(@RequestBody PersonDto personDto) {
        PassportDto passportByPerson = service.getPassportByPerson(personDto);

        return ResponseEntity.ok(passportByPerson);
    }

    @PostMapping
    public ResponseEntity<?> savePerson(@RequestBody PersonDto personDto) {
        service.savePerson(personDto);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-passport")
    public ResponseEntity<?> addPassportToPerson(@RequestBody PersonPassportRequest request) {
        service.addPassportToPerson(request.personDto(), request.passportDto());

        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<?> updatePersonById(@RequestBody PersonDto personDto) {
        service.updatePersonById(personDto);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deletePassportFromPerson(@RequestBody PersonDto personDto) {
        service.deletePassportFromPerson(personDto);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    ResponseEntity<?> deletePersonById(@RequestBody PersonDto personDto) {
        service.deletePersonById(personDto.id());

        return ResponseEntity.ok().build();
    }


}