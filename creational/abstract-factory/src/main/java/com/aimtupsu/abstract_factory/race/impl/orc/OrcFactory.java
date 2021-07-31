package com.aimtupsu.abstract_factory.race.impl.orc;

import com.aimtupsu.abstract_factory.race.RaceFactory;
import com.aimtupsu.abstract_factory.race.impl.orc.warrior.Grunt;
import com.aimtupsu.abstract_factory.race.impl.orc.worker.Peon;
import com.aimtupsu.abstract_factory.race.units.warrior.Warrior;
import com.aimtupsu.abstract_factory.race.units.worker.GoldMiner;
import com.aimtupsu.abstract_factory.race.units.worker.LumberWorker;

/**
 * Фабрика Орды.
 *
 * @author Vladimir.Shchepin
 */
public class OrcFactory implements RaceFactory {

    @Override
    public GoldMiner createGoldMiner() {
        return createPeon();
    }

    @Override
    public LumberWorker createLumberWorker() {
        return createPeon();
    }

    @Override
    public Warrior createWarrior() {
        final Grunt grunt = new Grunt();
        grunt.onCreate();
        return grunt;
    }

    /**
     * Создаёт нового раба.
     */
    private Peon createPeon() {
        final Peon peon = new Peon();
        peon.onCreate();
        return peon;
    }

}
