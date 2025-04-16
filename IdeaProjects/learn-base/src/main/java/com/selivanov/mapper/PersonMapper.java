package com.selivanov.mapper;

import com.selivanov.dto.PersonDto;
import com.selivanov.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(target = "passport.id", source = "passportId")
    Person toEntity(PersonDto personDto);
    @Mapping(target = "passportId", source = "passport.id")
    PersonDto toDto(Person person);
    List<PersonDto> toDtos(List<Person> persons);
}