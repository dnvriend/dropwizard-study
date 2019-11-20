package com.github.dnvriend.converter;

import com.github.dnvriend.dto.PersonDto;
import com.github.dnvriend.jpa.PersonJpa;

public class PersonConverter {

    private PersonConverter() {}

    public static PersonJpa dtoToJpa(PersonDto personDto) {
        return PersonJpa.builder()
            .id(personDto.getId())
            .name(personDto.getName())
            .age(personDto.getAge())
            .build();
    }

    public static PersonDto jpaToDto(PersonJpa personJpa) {
        return PersonDto.builder()
            .id(personJpa.getId())
            .name(personJpa.getName())
            .age(personJpa.getAge())
            .build();
    }
}
