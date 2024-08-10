package com.shantanu.foreign_key_demo_one_dto_two_entities.resourse;

import com.shantanu.foreign_key_demo_one_dto_two_entities.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
