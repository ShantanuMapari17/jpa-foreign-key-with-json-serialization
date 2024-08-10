package com.shantanu.foreign_key_demo_one_dto_two_entities.resourse;

import com.shantanu.foreign_key_demo_one_dto_two_entities.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
