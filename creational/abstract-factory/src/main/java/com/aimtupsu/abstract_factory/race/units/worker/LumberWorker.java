package com.aimtupsu.abstract_factory.race.units.worker;

/**
 * Добытчик древесины.
 *
 * @author Vladimir.Shchepin
 */
public interface LumberWorker extends Worker {

    /**
     * Добывает древесину.
     */
    void getLumber();

}
