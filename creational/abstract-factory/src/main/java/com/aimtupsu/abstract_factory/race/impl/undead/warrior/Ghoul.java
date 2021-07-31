package com.aimtupsu.abstract_factory.race.impl.undead.warrior;

import com.aimtupsu.abstract_factory.race.units.warrior.Warrior;
import com.aimtupsu.abstract_factory.race.units.warrior.parameters.WarriorStatus;
import com.aimtupsu.abstract_factory.race.units.worker.LumberWorker;
import com.aimtupsu.abstract_factory.race.units.worker.parameters.WorkerStatus;
import java.util.Random;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Вурдалак. Воин и добытчик дерева армии Тьмы.
 * Умеет добывать дерево.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@ToString
@EqualsAndHashCode
public class Ghoul implements LumberWorker, Warrior {

    private static final String[] QUOTES = {
            "Wuzzap.",
            "Must feed!"
    };

    private static final String[] PISSED_QUOTES = {
            "Me eat dead people!",
            "Me scary.",
            "Me eat brains!",
            "No guts, no gory."
    };

    @Getter
    private WorkerStatus workerStatus;
    @Getter
    private WarriorStatus warriorStatus;
    private final Random random = new Random();

    public Ghoul() {
        this.workerStatus = WorkerStatus.READY;
        this.warriorStatus = WarriorStatus.READY;
    }

    @Override
    public void onCreate() {
        log.info(QUOTES[0]);
    }

    @Override
    public void onSelect() {
        log.info(QUOTES[random.nextInt(55) % QUOTES.length]);
    }

    @Override
    public void getLumber() {
        log.info(QUOTES[random.nextInt(66) % QUOTES.length]);
        this.workerStatus = WorkerStatus.WORKS;
        this.warriorStatus = WarriorStatus.READY;
    }

    @Override
    public void attack() {
        log.info(PISSED_QUOTES[random.nextInt(55) % PISSED_QUOTES.length]);
        this.workerStatus = WorkerStatus.READY;
        this.warriorStatus = WarriorStatus.ATTACKS;
    }

}
