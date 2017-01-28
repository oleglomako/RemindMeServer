package com.oleglomako.remindme.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by oleg on 28.01.17.
 *
 * сущность из бд таблица remind
 */


// говорим что это сущность
@Entity
// говорим какая это таблица
@Table(name = "remind")
public class Remind {

    // говорим что это id
    @Id
    // говорим что id будет autoincrement
    @GeneratedValue(generator = "increment")
    // задаем для него генератор инкремента
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id; // long потому что мы быстро выйдем за пределы инта

    // говорим что это столбец таблицы с именем  title
    // не нулл и длина 50
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "remind_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date remindDate;

    // пустой конструктор обязателен
    public Remind() {
    }

    // гетеры и сетеры обязательны
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(Date remindDate) {
        this.remindDate = remindDate;
    }
}
