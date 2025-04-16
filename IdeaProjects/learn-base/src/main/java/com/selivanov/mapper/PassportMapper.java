package com.selivanov.mapper;

import com.selivanov.dto.PassportDto;
import com.selivanov.entity.Passport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassportMapper {
    Passport toEntity(PassportDto passportDto);
    PassportDto toDto(Passport passport);
}