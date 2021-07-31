package com.aimtupsu.unit.impl;

import com.aimtupsu.unit.CombatUnit;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * Лучник.
 */
@Log4j2
@Data
public class Archer implements CombatUnit {

    /**
     * Имя юнита.
     */
    private final String name;

    @Override
    public void attack() {
        log.info("Лучник {} атакует.", this.name);
    }

    @Override
    public void move() {
        log.info("Лучник {} в пути.", this.name);
    }

    @Override
    public String name() {
        return this.name;
    }

}
