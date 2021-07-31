package com.aimtupsu.abstract_factory.race.units.worker;

/**
 * Добытчик золота.
 *
 * @author Vladimir.Shchepin
 */
public interface GoldMiner extends Worker {

    /**
     * Добывает золото.
     */
    void mineGold();

}
