package com.aimtupsu.abstract_factory.race;

import com.aimtupsu.abstract_factory.race.impl.human.HumanFactory;
import com.aimtupsu.abstract_factory.race.impl.nightelf.NightElfFactory;
import com.aimtupsu.abstract_factory.race.impl.orc.OrcFactory;
import com.aimtupsu.abstract_factory.race.impl.undead.UndeadFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Раса.
 *
 * @author Vladimir.Shchepin
 */
@RequiredArgsConstructor
public enum Race {

    HUMAN(new HumanFactory()),
    ORC(new OrcFactory()),
    NIGHT_ELF(new NightElfFactory()),
    UNDEAD(new UndeadFactory());

    @Getter
    private final RaceFactory factory;
}
