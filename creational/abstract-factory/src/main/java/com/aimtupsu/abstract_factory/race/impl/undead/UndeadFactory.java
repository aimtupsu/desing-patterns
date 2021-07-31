package com.aimtupsu.abstract_factory.race.impl.undead;

import com.aimtupsu.abstract_factory.race.RaceFactory;
import com.aimtupsu.abstract_factory.race.impl.undead.warrior.Ghoul;
import com.aimtupsu.abstract_factory.race.impl.undead.worker.Acolyte;
import com.aimtupsu.abstract_factory.race.units.warrior.Warrior;
import com.aimtupsu.abstract_factory.race.units.worker.GoldMiner;
import com.aimtupsu.abstract_factory.race.units.worker.LumberWorker;

/**
 * Фабрика армии Тьмы.
 *
 * @author Vladimir.Shchepin
 */
public class UndeadFactory implements RaceFactory {

    @Override
    public GoldMiner createGoldMiner() {
        final Acolyte acolyte = new Acolyte();
        acolyte.onCreate();
        return acolyte;
    }

    @Override
    public LumberWorker createLumberWorker() {
        return getGhoul();
    }

    @Override
    public Warrior createWarrior() {
        return getGhoul();
    }

    /**
     * Создаёт вурдалака.
     */
    private Ghoul getGhoul() {
        final Ghoul ghoul = new Ghoul();
        ghoul.onCreate();
        return ghoul;
    }

}
