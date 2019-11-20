package com.github.dnvriend.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@Entity
public class PersonJpa {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
}
