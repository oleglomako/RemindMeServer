package com.oleglomako.remindme.server.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by oleg on 27.01.17.
 * <p>
 * Класс для конфигурации базы данных
 */

// говорим что этот класс конфига
@Configuration

// говорим сприг-котексту что будем использовать JPA а именно спринг-дата
// который построен на паттерне репозиторий
@EnableJpaRepositories("com.oleglomako.remindme.server.repository")

// включаем поддержку транзакций
@EnableTransactionManagement

// говорим где искать все репозитории и конфиги
@ComponentScan("com.oleglomako.remindme.server")

// чтобы конфигурация знала о файле db.properties
@PropertySource("classpath:db.properties")
public class DatabaseConfig {

    // с его помощю получим доступ к нашим проперти файлам
    // и сможем получать из проперти файла какие то значения
    @Resource
    private Environment env;

    // бин для работы с бд
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        // для отображения сущностей бд в виде классов
        // EntityManager предоставляет возможность автоматического создания
        // бинов и автоматического создания таблиц на основе наших бинов Entity и т п
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(env.getRequiredProperty("db.enttity.package"));

        // говорим что в качестве JPA провайдера используем Hibernate
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(getHibernateproperties());

        return em;
    }

    // получить настройки хибернейта
    private Properties getHibernateproperties() {
        try {
            Properties properties = new Properties();
            InputStream is = getClass().getClassLoader().getResourceAsStream("hibernate.properties");
            properties.load(is);

            return properties;
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't find 'hibernate.properties' in classpath!", e);
        }
    }

    // конфигурируем поддержку транзакций
    @Bean
    public PlatformTransactionManager platformTransactionManager(){
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory().getObject());

        return manager;
    }


    // метод который вернет нам набор данных datasource
    // он является связующим звеном между spring-data и базой данных
    @Bean
    public DataSource dataSource() {
        // создаем датасорс и конфигурируем его из библиотеки Апача dbcp
        BasicDataSource ds = new BasicDataSource();
        // говорим этим getRequiredProperty обязателен
        ds.setUrl(env.getRequiredProperty("db.url"));
        // указываем датасорсу какой драйвер использовать
        ds.setDriverClassName(env.getRequiredProperty("db.driver"));
        // говорим каким юзером и паролем заходить в бд
        ds.setUsername(env.getRequiredProperty("db.username"));
        ds.setPassword(env.getRequiredProperty("db.password"));

        return ds;
    }

}
