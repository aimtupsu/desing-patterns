package com.aimtupsu.abstract_factory.race.units.warrior;

import com.aimtupsu.abstract_factory.race.units.Unit;
import com.aimtupsu.abstract_factory.race.units.warrior.parameters.WarriorStatus;

/**
 * Воин.
 *
 * @author Vladimir.Shchepin
 */
public interface Warrior extends Unit {

    /**
     * Атакует.
     */
    void attack();

    /**
     * Возвращает статус воина.
     */
    WarriorStatus getWarriorStatus();

}
