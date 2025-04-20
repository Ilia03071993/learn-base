package com.selivanov.service;

import com.selivanov.dto.PassportDto;
import com.selivanov.entity.Passport;
import com.selivanov.mapper.PersonPassportMapper;
import com.selivanov.repository.PassportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PassportService {
    private final PassportRepository repository;
    private final PersonPassportMapper mapper;

//    @Transactional(readOnly = true)
//    public Optional<PassportDto> getPassportById(Integer id) {
//        return repository.findById(id)
//                .map(m -> mapper.toPassportDto(m));
//    }

//    @Transactional(readOnly = true)
//    public Passport getPassportEntityById(Integer id) {
//        return repository.findById(id).orElseThrow();
//    }

    @Transactional
    public void savePassport(PassportDto passportDto) {
        Passport passport = mapper.toPassport(passportDto);
        repository.save(passport);
    }

    @Transactional
    public Passport createOrGetPassport(PassportDto passportDto) {
        return repository.findById(passportDto.id())
                .orElse(repository.save(mapper.toPassport(passportDto)));
    }
}