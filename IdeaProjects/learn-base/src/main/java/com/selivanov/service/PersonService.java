package com.selivanov.service;

import com.selivanov.dto.PassportDto;
import com.selivanov.dto.PersonDto;
import com.selivanov.entity.Passport;
import com.selivanov.entity.Person;
import com.selivanov.mapper.PassportMapper;
import com.selivanov.mapper.PersonMapper;
import com.selivanov.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository repository;
    private final PersonMapper mapper;
    private final PassportService passportService;
    private final PassportMapper passportMapper;

    @Transactional(readOnly = true)
    public PersonDto getPerson(PersonDto personDto) {
        Person person = repository.findById(personDto.id()).orElseThrow();
        return mapper.toDto(person);
    }

    @Transactional(readOnly = true)
    public List<PersonDto> getPersons() {
        List<Person> persons = repository.findAll();
        return mapper.toDtos(persons);
    }

    @Transactional(readOnly = true)
    public PassportDto getPassportByPerson(PersonDto personDto) {
        Person person = repository.findById(personDto.id()).orElseThrow();
        Passport passport = person.getPassport();
        return passportMapper.toDto(passport);
    }

    @Transactional
    public void savePerson(PersonDto personDto) {
        Person person = mapper.toEntity(personDto);
        if (personDto.passportId() != null) {
            Passport passport = passportService.getPassportEntityById(personDto.passportId());
            person.setPassport(passport);
            repository.save(person);
        }
    }

    @Transactional
    public void addPassportToPerson(PersonDto personDto, PassportDto passportDto) {
        Person person = repository.findById(personDto.id()).orElseThrow();
        PassportDto passportById = passportService.getPassportById(passportDto.id()).orElse(
                passportService.savePassport(passportDto)
        );

        if (person.getPassport() != null) {
            throw new IllegalArgumentException("Passport is already exist");
        } else if (passportById.id().equals(passportDto.id())) {
            Passport passport = passportMapper.toEntity(passportById);
            person.setPassport(passport);
            repository.save(person);
        }

        Passport passport = passportMapper.toEntity(passportById);
        person.setPassport(passport);
        repository.save(person);
    }

    @Transactional
    public void updatePersonById(PersonDto personDto) {
        Person updatablePerson = repository.findById(personDto.id()).orElseThrow();
        updatablePerson.setName(personDto.name());
        repository.save(updatablePerson);
    }

    @Transactional
    public void deletePassportFromPerson(PersonDto personDto) {
        Person person = repository.findById(personDto.id()).orElseThrow();
        Passport passport = person.getPassport();
        if (passport != null) {
            person.setPassport(null);
            repository.save(person);
        }
    }

    @Transactional
    public void deletePersonById(Integer id) {
        Person person = repository.findById(id).orElseThrow();
        repository.delete(person);
    }
}