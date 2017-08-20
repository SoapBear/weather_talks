package ru.soapbear.weathertalks.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.soapbear.weathertalks.entity.City;

@Repository
public class TestDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveCity(City city) {
        Session session = sessionFactory.getCurrentSession();
        session.save(city);
    }

    @Transactional
    public City getCityById(int cityId) {

        Session session = sessionFactory.getCurrentSession();

        City city = null;
        try {
            city = session.get(City.class, cityId);
        } catch (Exception e) {
            System.out.println("You are fucking idiot");
            e.printStackTrace();
        }

        return city;
    }
}
