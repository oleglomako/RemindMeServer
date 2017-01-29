package com.oleglomako.remindme.server.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Collections;
import java.util.List;

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

public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // будем использовать Jackson для конвертации в JSON
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));

        converters.add(converter);
    }
}
