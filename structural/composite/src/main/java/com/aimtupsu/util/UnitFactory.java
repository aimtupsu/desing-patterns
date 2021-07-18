package com.aimtupsu.util;

import com.aimtupsu.unit.impl.Archer;
import com.aimtupsu.unit.impl.CombatSquad;
import com.aimtupsu.unit.impl.Swordsman;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UnitFactory {

    public CombatSquad createSquad() {
        return new CombatSquad(NameGenerator.generateSquadName());
    }

    public Swordsman createSwordsman() {
        return new Swordsman(NameGenerator.generateUnitName());
    }

    public Archer createArcher() {
        return new Archer(NameGenerator.generateUnitName());
    }

}
