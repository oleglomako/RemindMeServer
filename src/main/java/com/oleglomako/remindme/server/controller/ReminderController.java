package com.oleglomako.remindme.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by oleg on 27.01.17.
 *
 * Класс контроллер который будет отдавать нам наши напоминалки
 *
 * все контроллеры это сервлеты - это классы которые позволяют
 * общаться через HTTP протокол сервер-клиент посредством HTTP методов
 * базируясь на реквесте и респонсе запрос-ответ
 */

// этой аннотацией говорим что этот клас будет контроллером это и есть наш сервлет
@Controller

// основной контроллер
// на который будут идти все запросы
// и из которого будут идти все ответы к нашему RemindMe приложению
// говорим как попасть на наш контроллер например http://localhost:8080/reminder/
@RequestMapping("/reminder")

public class ReminderController {

    // возвращаем строку методом GET напр http://localhost:8080/reminder/get
    @RequestMapping(value = "/get", method = RequestMethod.GET)

    // говорим что в виде тела ответа хотим вернуть строку
    @ResponseBody

    // в качестве параметра передаем модель для отображения например название html страницы или jsp стрраницы
    public String gerReminder(ModelMap model) {
        return "My reminder";
    }

}
