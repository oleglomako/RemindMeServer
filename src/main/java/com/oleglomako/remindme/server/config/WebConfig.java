package com.oleglomako.remindme.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by oleg on 27.01.17.
 */

// говорим что наш класс является конфигурацией
// которую нужно выполнить перед тем как разворачивать контекст спринга
@Configuration

// включаем режим WebMvc
// что даст нам возможность использования контроллеров и РЕСТ-контроллеров
@EnableWebMvc

// говорим где искать все наши бины - все наши (контроллеры) классы, компоненты, репозитории
@ComponentScan("com.oleglomako.remindme.server")

public class WebConfig extends WebMvcConfigurerAdapter{
}
