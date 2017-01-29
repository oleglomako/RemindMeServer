package com.oleglomako.remindme.server.sevice;

import com.oleglomako.remindme.server.entity.Remind;
import com.oleglomako.remindme.server.repository.RemindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oleg on 29.01.17.
 */

@Service
public class ReminderServiceImpl implements ReminderService{

    // данные сервисы могут выполнять разную логику
    // TODO тут можно подключить наши репозитории их может быть несколько -> @
    // TODO также тут могут быть джава-мейл сервисы и т п
    // TODO тут можно дергать другие внешние системы рест апи
    // TODO здесь выполняем всю бизнеслогику а контродллеры их просто вызывают


    // но мы пока будем просто вызывать наш репозиторий так как унас пока нет больше логики
    // проинициализируем наш репозиторий
    @Autowired
    private RemindRepository repository;


    public List<Remind> getAll() {
        return repository.findAll();
    }

    public Remind getByID(long id) {
        return repository.findOne(id);
    }

    public Remind save(Remind remind) {
        return repository.saveAndFlush(remind);
    }

    public void remove(long id) {
        repository.delete(id);
    }
}
