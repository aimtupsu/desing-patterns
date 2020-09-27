package com.aimtupsu.abstract_factory.race;

import com.aimtupsu.abstract_factory.race.units.warrior.Warrior;
import com.aimtupsu.abstract_factory.race.units.worker.GoldMiner;
import com.aimtupsu.abstract_factory.race.units.worker.LumberWorker;

/**
 * Фабрика расы.
 *
 * @author Vladimir.Shchepin
 */
public interface RaceFactory {

    /**
     * Создаёт добытчика золота.
     */
    GoldMiner createGoldMiner();

    /**
     * Создаёт добытчика древесины.
     */
    LumberWorker createLumberWorker();

    /**
     * Создаёт воина.
     */
    Warrior createWarrior();

}
