package com.oleglomako.remindme.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by oleg on 27.01.17.
 *
 * Класс для конфигурации базы данных
 */

// говорим что этот класс конфига
@Configuration

// говорим сприг-котексту что будем использовать JPA а именно спринг-дата
// который построен на паттерне репозиторий
@EnableJpaRepositories()

public class DatabaseConfig {
}
