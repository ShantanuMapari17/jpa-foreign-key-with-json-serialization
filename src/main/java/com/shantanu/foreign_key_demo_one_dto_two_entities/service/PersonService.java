package com.shantanu.foreign_key_demo_one_dto_two_entities.service;

import com.shantanu.foreign_key_demo_one_dto_two_entities.dto.PersonDTO;
import com.shantanu.foreign_key_demo_one_dto_two_entities.entity.Person;
import com.shantanu.foreign_key_demo_one_dto_two_entities.entity.Property;
import com.shantanu.foreign_key_demo_one_dto_two_entities.mapper.PersonMapper;
import com.shantanu.foreign_key_demo_one_dto_two_entities.resourse.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = PersonMapper.toEntity(personDTO);
        person = personRepository.save(person);
        return PersonMapper.toDTO(person);
    }

    @Transactional
    public PersonDTO updatePerson(Long id, PersonDTO personDTO) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setName(personDTO.getName());
            person.setAge(personDTO.getAge());
            person.getProperties().clear();

            List<Property> properties = PersonMapper.mapToProperties(personDTO.getProperties(), person);
            person.getProperties().addAll(properties);

            person = personRepository.save(person);
            return PersonMapper.toDTO(person);
        } else {
            // Handle entity not found (throw exception or return null)
            return null;
        }
    }

    @Transactional(readOnly = true)
    public PersonDTO getPersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.map(PersonMapper::toDTO).orElse(null);
    }

    @Transactional
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<PersonDTO> getAllPersons() {
        return personRepository.findAll().stream()
                .map(PersonMapper::toDTO)
                .toList();
    }
}


