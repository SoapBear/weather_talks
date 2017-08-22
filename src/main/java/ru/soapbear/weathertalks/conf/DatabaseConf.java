package ru.soapbear.weathertalks.conf;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * Created by Pavel.Krizskiy on 8/21/2017.
 *
 * This class contains configuration needed for establishing database connection.
 */
@Configuration
@PropertySource({
        "classpath:database.properties",
        "classpath:hibernate.properties"})
public class DatabaseConf {

    @Value("${driverClass}")
    private String driverClass;

    @Value("${jdbcUrl}")
    private String jdbcUrl;

    @Value("${user}")
    private String user;

    @Value("${password}")
    private String password;

    @Value("${minPoolSize}")
    private int minPoolSize;

    @Value("${maxPoolSize}")
    private int maxPoolSize;

    @Value("${maxIdleTime}")
    private int maxIdleTime;

    @Value("${packagesToScan}")
    private String packagesToScan;

    @Value("${hibernateDialect}")
    private String hibernateDialect;

    @Value("${hibernateShowSql}")
    private String hibernateShowSql;

    @Bean
    public AbstractPoolBackedDataSource dataSource() {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        try {
            dataSource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            System.out.println("Cannot set database driver class.");
            e.printStackTrace();
        }

        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setMinPoolSize(minPoolSize);
        dataSource.setMaxPoolSize(maxPoolSize);
        dataSource.setMaxIdleTime(maxIdleTime);

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(AbstractPoolBackedDataSource dataSource) {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setPackagesToScan(packagesToScan);
        sessionFactory.setDataSource(dataSource);

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", hibernateDialect);
        hibernateProperties.setProperty("hibernate.show_sql", hibernateShowSql);

        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(@Qualifier("sessionFactory") SessionFactory sessionFactory) {

        HibernateTransactionManager transactionManager = new HibernateTransactionManager();

        transactionManager.setSessionFactory(sessionFactory);

        return transactionManager;
    }
}
