package com.aimtupsu.dao.impl;

import com.aimtupsu.dao.Dao;
import com.aimtupsu.model.db.DbEntry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Getter;

public class DaoImpl implements Dao {

    /**
     * Наша псевдо база данных.
     */
    @Getter
    private final Set<DbEntry> dbSet = new HashSet<>();

    @Override
    public void save(DbEntry entry) {
        dbSet.add(entry);
    }

    @Override
    public List<DbEntry> getAll() {
        return new ArrayList<>(dbSet);
    }

}
