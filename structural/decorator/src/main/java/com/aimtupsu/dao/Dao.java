package com.aimtupsu.dao;

import com.aimtupsu.model.db.DbEntry;
import java.util.List;

/**
 * Интерфейс доступа к БД.
 */
public interface Dao {

    /**
     * Сохраняет новую сущность в БД.
     *
     * @param entry сохраняемая сущность.
     */
    void save(DbEntry entry);

    /**
     * Возвращает список всех сущностей из БД.
     * Если в БД пусто, вернётся пустой список.
     *
     * @return списов всех сущностей из БД.
     */
    List<DbEntry> getAll();

}
