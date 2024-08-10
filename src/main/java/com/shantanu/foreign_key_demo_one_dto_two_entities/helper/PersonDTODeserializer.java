package com.shantanu.foreign_key_demo_one_dto_two_entities.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.shantanu.foreign_key_demo_one_dto_two_entities.dto.PersonDTO;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

public class PersonDTODeserializer extends JsonDeserializer<PersonDTO> {

    @Override
    public PersonDTO deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode rootNode = p.getCodec().readTree(p);
        PersonDTO personDTO = new PersonDTO();

        Iterator<Entry<String, JsonNode>> fields = rootNode.fields();
        while (fields.hasNext()) {
            Entry<String, JsonNode> field = fields.next();
            String fieldName = field.getKey();
            JsonNode value = field.getValue();

            switch (fieldName) {
                case "name":
                    personDTO.setName(value.asText());
                    break;
                case "age":
                    personDTO.setAge(value.asInt());
                    break;
                default:
                    personDTO.getProperties().put(fieldName, value.asText());
                    break;
            }
        }

        return personDTO;
    }
}

