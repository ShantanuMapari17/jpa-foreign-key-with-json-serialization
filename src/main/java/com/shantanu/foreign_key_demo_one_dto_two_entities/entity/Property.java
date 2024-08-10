package com.shantanu.foreign_key_demo_one_dto_two_entities.entity;


import jakarta.persistence.*;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "property_key")  // Renaming column
    private String key;

    @Column(name = "property_value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    // Constructors, Getters, Setters, toString (Lombok annotations can be used)

    public Property(Integer id, String key, String value, Person person) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.person = person;
    }

    public Property() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
