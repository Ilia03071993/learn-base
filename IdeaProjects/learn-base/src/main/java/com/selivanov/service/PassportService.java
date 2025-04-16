package com.selivanov.service;

import com.selivanov.dto.PassportDto;
import com.selivanov.entity.Passport;
import com.selivanov.mapper.PassportMapper;
import com.selivanov.repository.PassportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassportService {
    private final PassportRepository repository;
    private final PassportMapper mapper;

    @Transactional(readOnly = true)
    public Optional<PassportDto> getPassportById(Integer id) {
        return repository.findById(id)
                .map(m -> mapper.toDto(m));
    }

    @Transactional(readOnly = true)
    public Passport getPassportEntityById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    public PassportDto savePassport(PassportDto passportDto) {
        Passport passport = mapper.toEntity(passportDto);
        Passport savedPassport = repository.save(passport);
        return mapper.toDto(savedPassport);
    }

    @Transactional
    public void deletePassport(Passport passport) {
        repository.delete(passport);
    }
}