package com.shantanu.foreign_key_demo_one_dto_two_entities.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int age;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Property> properties;

    // Constructors, Getters, Setters, toString (Lombok annotations can be used)

    public Person() {
    }

    public Person(Integer id, String name, int age, List<Property> properties) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.properties = properties;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
