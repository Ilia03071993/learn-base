package com.selivanov.mapper;

import com.selivanov.dto.PassportDto;
import com.selivanov.dto.PersonDto;
import com.selivanov.entity.Passport;
import com.selivanov.entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-20T11:57:51+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class PersonPassportMapperImpl implements PersonPassportMapper {

    @Override
    public Person toPerson(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setPassport( personDtoToPassport( personDto ) );
        person.setId( personDto.id() );
        person.setName( personDto.name() );

        return person;
    }

    @Override
    public PersonDto toPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        Integer passportId = null;
        Integer id = null;
        String name = null;

        passportId = personPassportId( person );
        id = person.getId();
        name = person.getName();

        PersonDto personDto = new PersonDto( id, name, passportId );

        return personDto;
    }

    @Override
    public List<PersonDto> toPersonsDto(List<Person> persons) {
        if ( persons == null ) {
            return null;
        }

        List<PersonDto> list = new ArrayList<PersonDto>( persons.size() );
        for ( Person person : persons ) {
            list.add( toPersonDto( person ) );
        }

        return list;
    }

    @Override
    public Passport toPassport(PassportDto passportDto) {
        if ( passportDto == null ) {
            return null;
        }

        Passport passport = new Passport();

        passport.setId( passportDto.id() );
        passport.setNumber( passportDto.number() );
        passport.setSeries( passportDto.series() );

        return passport;
    }

    @Override
    public PassportDto toPassportDto(Passport passport) {
        if ( passport == null ) {
            return null;
        }

        Integer id = null;
        Integer number = null;
        Integer series = null;

        id = passport.getId();
        number = passport.getNumber();
        series = passport.getSeries();

        PassportDto passportDto = new PassportDto( id, number, series );

        return passportDto;
    }

    @Override
    public void updatePerson(Person updatablePerson, PersonDto personDto) {
        if ( personDto == null ) {
            return;
        }

        updatablePerson.setId( personDto.id() );
        updatablePerson.setName( personDto.name() );
    }

    protected Passport personDtoToPassport(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        Passport passport = new Passport();

        passport.setId( personDto.passportId() );

        return passport;
    }

    private Integer personPassportId(Person person) {
        if ( person == null ) {
            return null;
        }
        Passport passport = person.getPassport();
        if ( passport == null ) {
            return null;
        }
        Integer id = passport.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
