package com.aimtupsu.abstract_factory.race.impl.human.worker;

import com.aimtupsu.abstract_factory.race.units.worker.GoldMiner;
import com.aimtupsu.abstract_factory.race.units.worker.LumberWorker;
import com.aimtupsu.abstract_factory.race.units.worker.parameters.WorkerStatus;
import java.util.Random;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Крестьянин. Рабочий Альянса.
 * Умеет добывать золото и древесину.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@ToString
@EqualsAndHashCode
public class Peasant implements GoldMiner, LumberWorker {

    private static final String CREATE_QUOTE = "Ready to work.";
    private static final String[] SELECT_QUOTES = {
            "Yes, milord?",
            "What is it?",
            "More work?",
            "What?"
    };
    private static final String[] WORK_QUOTES = {
            "Right-o.",
            "Yes, milord.",
            "All right.",
            "Off I go, then!"
    };

    @Getter
    private WorkerStatus workerStatus;
    private final Random random = new Random();

    public Peasant() {
        this.workerStatus = WorkerStatus.READY;
    }

    @Override
    public void mineGold() {
        goToWork();
    }

    @Override
    public void getLumber() {
        goToWork();
    }

    @Override
    public void onCreate() {
        log.info(CREATE_QUOTE);
    }

    @Override
    public void onSelect() {
        log.info(SELECT_QUOTES[random.nextInt(55) % SELECT_QUOTES.length]);
    }

    /**
     * Отправиться работать.
     */
    private void goToWork() {
        sayOnGoingToWork();
        this.workerStatus = WorkerStatus.WORKS;
    }

    /**
     * Сказать, отправляясь на работу.
     */
    private void sayOnGoingToWork() {
        log.info(WORK_QUOTES[random.nextInt(66) % WORK_QUOTES.length]);
    }

}
