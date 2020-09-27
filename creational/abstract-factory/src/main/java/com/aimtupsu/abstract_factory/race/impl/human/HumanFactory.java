package com.aimtupsu.abstract_factory.race.impl.human;

import com.aimtupsu.abstract_factory.race.RaceFactory;
import com.aimtupsu.abstract_factory.race.impl.human.warrior.Footman;
import com.aimtupsu.abstract_factory.race.impl.human.worker.Peasant;
import com.aimtupsu.abstract_factory.race.units.warrior.Warrior;
import com.aimtupsu.abstract_factory.race.units.worker.GoldMiner;
import com.aimtupsu.abstract_factory.race.units.worker.LumberWorker;

/**
 * Фабрика Альянса.
 *
 * @author Vladimir.Shchepin
 */
public class HumanFactory implements RaceFactory {

    @Override
    public GoldMiner createGoldMiner() {
        return createPeasant();
    }

    @Override
    public LumberWorker createLumberWorker() {
        return createPeasant();
    }

    @Override
    public Warrior createWarrior() {
        final Footman footman = new Footman();
        footman.onCreate();
        return footman;
    }

    /**
     * Создаёт нового крестьянина.
     */
    private Peasant createPeasant() {
        final Peasant peasant = new Peasant();
        peasant.onCreate();
        return peasant;
    }

}
