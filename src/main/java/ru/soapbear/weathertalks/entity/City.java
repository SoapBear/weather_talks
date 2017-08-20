package ru.soapbear.weathertalks.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sw_cities", schema = "public")
@Data
public class City implements Serializable {

    @Id
    @Column(name = "city_id")
    private int cityId;

    @ManyToOne(targetEntity = Country.class, fetch = FetchType.EAGER)
    @JoinColumn(name="city_country")
    private Country cityCountry;

    @Column(name = "city_name")
    private String cityName;
}
