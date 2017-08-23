package ru.soapbear.weathertalks.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Pavel.Krizskiy on 20.08.2017.
 *
 * Mapping of sw_users_rating table's fields.
 */
@Entity
@Table(name = "sw_users_rating", schema = "public")
@Data
public class UsersRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long userId;

    // TODO Add proper annotations
    @JoinColumn(name="weather_id")
    private Weather weather;

    @Column(name = "rating")
    private int rating;

}
