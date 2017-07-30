package ru.soapbear.weathertalks.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.soapbear.weathertalks.entity.TestEntity;

@Repository
public class TestDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void testQuery(TestEntity testEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(testEntity);
    }
}
