package com.oleglomako.remindme.server.repository;

import com.oleglomako.remindme.server.entity.Remind;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by oleg on 29.01.17.
 * <p>
 * репозиторий для сущности Remind
 */

public interface RemindRepository extends JpaRepository<Remind, Long> {

}
