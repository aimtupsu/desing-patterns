package com.aimtupsu.abstract_factory.race.units.worker;

import com.aimtupsu.abstract_factory.race.units.Unit;
import com.aimtupsu.abstract_factory.race.units.worker.parameters.WorkerStatus;

/**
 * Рабочий.
 *
 * @author Vladimir.Shchepin
 */
public interface Worker extends Unit {

    /**
     * Возвращает статус рабочего.
     */
    WorkerStatus getWorkerStatus();

}
