package com.shantanu.foreign_key_demo_one_dto_two_entities.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shantanu.foreign_key_demo_one_dto_two_entities.helper.PersonDTODeserializer;
import com.shantanu.foreign_key_demo_one_dto_two_entities.helper.PersonDTOSerializer;

import java.util.HashMap;
import java.util.Map;
@JsonDeserialize(using = PersonDTODeserializer.class)
@JsonSerialize(using = PersonDTOSerializer.class)
public class PersonDTO {

    private String name;
    private int age;
    private Map<String, String> properties;

    // Constructors, Getters, Setters, toString (Lombok annotations can be used)

    public PersonDTO() {
        this.properties = new HashMap<>();
    }

    public PersonDTO(String name, int age, Map<String, String> properties) {
        this.name = name;
        this.age = age;
        this.properties = properties != null ? properties : new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

}