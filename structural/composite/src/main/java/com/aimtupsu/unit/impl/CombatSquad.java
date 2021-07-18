package com.aimtupsu.unit.impl;

import com.aimtupsu.unit.CombatUnit;
import com.aimtupsu.unit.Squad;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * Боевой отряд.
 */
@Log4j2
@Data
public class CombatSquad implements CombatUnit, Squad<CombatUnit> {

    /**
     * Название отряда.
     */
    private final String name;

    /**
     * Множество юнитов в отряде.
     */
    private final Set<CombatUnit> units = new HashSet<>();

    @Override
    public void attack() {
        if (units.size() > 0) {
            log.info("Отряд {} атакует.", this.name);
            units.forEach(CombatUnit::attack);
        } else {
            log.info("Отряд {} пуст. Воевать некому.", this.name);
        }
    }

    @Override
    public void move() {
        if (units.size() > 0) {
            log.info("Отряд {} в пути.", this.name);
            units.forEach(CombatUnit::move);
        } else {
            log.info("Отряд {} пуст. Идти некому.", this.name);
        }
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public void add(final CombatUnit unit) {
        units.add(unit);
    }

    @Override
    public boolean remove(final CombatUnit unit) {
        return units.remove(unit);
    }

}
