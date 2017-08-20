package ru.soapbear.weathertalks.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "sw_countries", schema = "public")
public class Country implements Serializable {

    @Id
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "country_name")
    private String countryName;

}
