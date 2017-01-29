package com.oleglomako.remindme.server.controller;

import com.oleglomako.remindme.server.entity.Remind;
import com.oleglomako.remindme.server.repository.RemindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by oleg on 27.01.17.
 * <p>
 * Класс контроллер который будет отдавать нам наши напоминалки
 * <p>
 * все контроллеры это сервлеты - это классы которые позволяют
 * общаться через HTTP протокол сервер-клиент посредством HTTP методов
 * базируясь на реквесте и респонсе запрос-ответ
 */

// этой аннотацией говорим что этот клас будет РЕСТ-контроллером это и есть наш сервлет
@RestController

// основной контроллер
// на который будут идти все запросы
// и из которого будут идти все ответы к нашему RemindMe приложению
// говорим как попасть на наш контроллер например http://localhost:8080/reminder/
@RequestMapping("/reminder")

public class ReminderController {

    // проверяем работу наших репозиториев
    @Autowired   // говорим проинициализировать наш обьект
    private RemindRepository remindRepository;

    // возвращаем строку методом GET напр http://localhost:8080/reminder/get
    @RequestMapping(value = "/get", method = RequestMethod.GET)

    // говорим что в виде тела ответа хотим вернуть строку
    @ResponseBody

    // для отображения html страницы или jsp стрраницы
    public Remind getReminder() {
        List<Remind> all = remindRepository.findAll();
        return createMockRemind();
    }

    private Remind createMockRemind() {
        Remind remind = new Remind();
        remind.setId(1);
        remind.setRemindDate(new Date());
        remind.setTitle("My first remind");

        return remind;
    }

}
