package com.aimtupsu;

import com.aimtupsu.unit.CombatUnit;
import com.aimtupsu.unit.Unit;
import com.aimtupsu.unit.impl.Archer;
import com.aimtupsu.unit.impl.CombatSquad;
import com.aimtupsu.unit.impl.Swordsman;
import com.aimtupsu.util.UnitFactory;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CompositeDemo {

    public static void main(String[] args) {
        log.info("Создадим мечника и отправим его воевать.");
        final Swordsman swordsman = UnitFactory.createSwordsman();
        swordsman.move();
        swordsman.attack();
        log.info("\n");


        log.info("Создадим лучника и отправим его воевать.");
        final Archer archer = UnitFactory.createArcher();
        archer.move();
        archer.attack();
        log.info("\n");


        log.info("Создадим отряд и отправим его воевать.");
        final CombatSquad combatSquad = UnitFactory.createSquad();
        combatSquad.move();
        combatSquad.attack();
        log.info("\n");

        log.info("Наполним отряд и отправим его воевать.");
        combatSquad.add(UnitFactory.createSwordsman());
        combatSquad.add(UnitFactory.createArcher());
        combatSquad.move();
        combatSquad.attack();
        log.info("\n");

        log.info("Выберем всех юнитов и отправим их всех воевать.");
        final Set<CombatUnit> combatUnits = new HashSet<>();
        combatUnits.add(swordsman);
        combatUnits.add(archer);
        combatUnits.add(combatSquad);
        combatUnits.forEach(Unit::move);
        combatUnits.forEach(CombatUnit::attack);
        log.info("\n");

        log.info("Добавим всех созданных юнитов и отряд в новый отряд и отрпавим всех их вовевать.");
        final CombatSquad bigCombatSquad = UnitFactory.createSquad();
        bigCombatSquad.add(swordsman);
        bigCombatSquad.add(archer);
        bigCombatSquad.add(combatSquad);
        bigCombatSquad.move();
        bigCombatSquad.attack();
    }

}
