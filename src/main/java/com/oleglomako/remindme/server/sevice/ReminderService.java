package com.oleglomako.remindme.server.sevice;

import com.oleglomako.remindme.server.entity.Remind;

import java.util.List;

/**
 * Created by oleg on 29.01.17.
 */
public interface ReminderService {

    List<Remind> getAll();

    Remind getByID(long id);

    Remind save(Remind remind);

    void remove(long id);
}
