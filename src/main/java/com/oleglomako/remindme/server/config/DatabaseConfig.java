package com.oleglomako.remindme.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * Created by oleg on 27.01.17.
 *
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

}
