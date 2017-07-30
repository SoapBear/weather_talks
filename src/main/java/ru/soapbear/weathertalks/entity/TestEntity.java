package ru.soapbear.weathertalks.entity;

import javax.persistence.Entity;

@Entity
public class TestEntity {
    private String string;

    public TestEntity() {}

    public TestEntity(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
