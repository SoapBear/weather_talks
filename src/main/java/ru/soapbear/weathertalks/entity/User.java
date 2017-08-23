package ru.soapbear.weathertalks.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Pavel.Krizskiy on 20.08.2017.
 *
 * Mapping of sw_users table's fields.
 */
@Entity
@Table(name = "sw_users", schema = "public")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long userId;

    @ManyToOne(targetEntity = City.class, fetch = FetchType.EAGER)
    @JoinColumn(name="city_id")
    private City city;

    @Column(name = "register_date")
    private Timestamp registerDate;
}
