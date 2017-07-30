package ru.soapbear.weathertalks.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class TestEntity {
    @Id
    private String string;
}
