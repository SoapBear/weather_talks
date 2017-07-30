package ru.soapbear.weathertalks.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

public class TestDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void testQuery() {
        Session session = sessionFactory.getCurrentSession();
        // session.save();
    }
}
