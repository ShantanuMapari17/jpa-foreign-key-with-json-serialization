package com.shantanu.foreign_key_demo_one_dto_two_entities.mapper;

import com.shantanu.foreign_key_demo_one_dto_two_entities.dto.PersonDTO;
import com.shantanu.foreign_key_demo_one_dto_two_entities.entity.Person;
import com.shantanu.foreign_key_demo_one_dto_two_entities.entity.Property;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonMapper {

    public static Person toEntity(PersonDTO dto) {
        Person person = new Person();
        person.setName(dto.getName());
        person.setAge(dto.getAge());

        List<Property> properties = mapToProperties(dto.getProperties(), person);
        person.setProperties(properties);

        return person;
    }

    public static List<Property> mapToProperties(Map<String, String> propertiesMap, Person person) {
        return propertiesMap.entrySet().stream()
                .map(entry -> {
                    Property property = new Property();
                    property.setKey(entry.getKey());
                    property.setValue(entry.getValue());
                    property.setPerson(person);
                    return property;
                })
                .collect(Collectors.toList());
    }

    public static PersonDTO toDTO(Person person) {
        Map<String, String> properties = person.getProperties().stream()
                .collect(Collectors.toMap(Property::getKey, Property::getValue));

        PersonDTO dto = new PersonDTO();
        dto.setName(person.getName());
        dto.setAge(person.getAge());
        dto.setProperties(properties);

        return dto;
    }
}
