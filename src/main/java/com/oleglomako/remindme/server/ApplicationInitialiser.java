package com.oleglomako.remindme.server;

import com.oleglomako.remindme.server.config.WebConfig;
import org.springframework.context.ApplicationContextException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by oleg on 27.01.17.
 *
 * Данный класс будет инициализировать наш спринг-контекст
 * а именно разворачивать его и создавать
 */

public class ApplicationInitialiser implements WebApplicationInitializer {

    // имя на основаниии которого зарегистрирован диспетчер
    private final static String DISPATCER = "dispatcher";

    // регистрируем нашу конфигурацию в спринговом контексте
    // говорим что нужно выполнить какие то действия
    // перед тем как будет разворачиваться наш сервлет-контекст

    // этот метод использует javax.servlet нужно добавить эту зависимость в pom.xml
    public void onStartup(ServletContext servletContext) throws ServletException {

        // создаем наш веб-контекст
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        // в котором зарегистрируем веб конфиг
        ctx.register(WebConfig.class);

        // и в него передадим наш контекст
        servletContext.addListener(new ContextLoaderListener(ctx));

        // в диспетчер сервлетов добавим наш сервлет контекст
        // и замапим его на определенный URL
        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCER, new DispatcherServlet(ctx));

        // в сервлет добавляем мапинг указываем по какому контекст руту будет доступно енаше приложение
        servlet.addMapping("/");

        // указываем в каком порядке инициализировать если будем мапить несколько сервлетов
        servlet.setLoadOnStartup(1);


    }
}
