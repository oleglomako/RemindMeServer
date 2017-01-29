package com.oleglomako.remindme.server.controller;

import com.oleglomako.remindme.server.entity.Remind;
import com.oleglomako.remindme.server.repository.RemindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class ReminderController {

    // проверяем работу наших репозиториев
    @Autowired   // говорим проинициализировать наш обьект
    private RemindRepository remindRepository;

    // возвращаем строку методом GET
    // говорим как попасть на наш контроллер например http://localhost:8080/reminders/
    @RequestMapping(value = "/reminders", method = RequestMethod.GET)
    // для отображения html страницы или jsp страницы
    @ResponseBody
    // возвращает все напоминания
    public List<Remind> getAllReminders() {
        return remindRepository.findAll();
    }

    // вернем одно напоминание по ид
    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Remind getReminder(@PathVariable("id") long remindID) {
        return remindRepository.findOne(remindID);
    }

    // запишем в базу одно напоминание
    @RequestMapping(value = "/reminders", method = RequestMethod.POST)
    @ResponseBody
    public Remind saveReminder(@RequestBody Remind remind) {
        return remindRepository.saveAndFlush(remind);
    }

    // удвлим из базы одно напоминание по ид
    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void delete(@PathVariable long id) {
        remindRepository.delete(id);
    }

}
