package com.shantanu.foreign_key_demo_one_dto_two_entities.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.shantanu.foreign_key_demo_one_dto_two_entities.dto.PersonDTO;

import java.io.IOException;
import java.util.Map;

public class PersonDTOSerializer extends JsonSerializer<PersonDTO> {

    @Override
    public void serialize(PersonDTO personDTO, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        gen.writeStartObject();
        gen.writeStringField("name", personDTO.getName());
        gen.writeNumberField("age", personDTO.getAge());

        // Flatten properties
        for (Map.Entry<String, String> entry : personDTO.getProperties().entrySet()) {
            gen.writeStringField(entry.getKey(), entry.getValue());
        }

        gen.writeEndObject();
    }
}

