package com.aimtupsu.abstract_factory.race.impl.nightelf;

import com.aimtupsu.abstract_factory.race.RaceFactory;
import com.aimtupsu.abstract_factory.race.impl.nightelf.warrior.Archer;
import com.aimtupsu.abstract_factory.race.impl.nightelf.worker.Wisp;
import com.aimtupsu.abstract_factory.race.units.warrior.Warrior;
import com.aimtupsu.abstract_factory.race.units.worker.GoldMiner;
import com.aimtupsu.abstract_factory.race.units.worker.LumberWorker;

/**
 * Фабрика Ночных эльфов.
 *
 * @author Vladimir.Shchepin
 */
public class NightElfFactory implements RaceFactory {

    @Override
    public GoldMiner createGoldMiner() {
        return createWisp();
    }

    @Override
    public LumberWorker createLumberWorker() {
        return createWisp();
    }

    @Override
    public Warrior createWarrior() {
        final Archer archer = new Archer();
        archer.onCreate();
        return archer;
    }

    /**
     * Создаёт нового светлячка.
     */
    private Wisp createWisp() {
        final Wisp wisp = new Wisp();
        wisp.onCreate();
        return wisp;
    }

}
