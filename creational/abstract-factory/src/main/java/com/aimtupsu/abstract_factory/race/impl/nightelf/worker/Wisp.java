package com.aimtupsu.abstract_factory.race.impl.nightelf.worker;

import com.aimtupsu.abstract_factory.race.units.worker.GoldMiner;
import com.aimtupsu.abstract_factory.race.units.worker.LumberWorker;
import com.aimtupsu.abstract_factory.race.units.worker.parameters.WorkerStatus;
import java.util.Random;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Светлячок. Рабочий Ночных эльфов.
 * Умеет добывать золото и древесину.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@ToString
@EqualsAndHashCode
public class Wisp implements GoldMiner, LumberWorker {

    private static final String[] QUOTES = {
            "Asasdasbvfdfhjkl.",
            "Edasghfdgg.",
            "Ooodsadaasfasgsdfhg?",
            "Dyqwrfagesfdjfhkgfswqere.",
            "ERREWEWEW!",
            "Ueqw?"
    };

    @Getter
    private WorkerStatus workerStatus;
    private final Random random = new Random();

    public Wisp() {
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
        saySomething();
    }

    @Override
    public void onSelect() {
        saySomething();
    }

    /**
     * Отправиться работать.
     */
    private void goToWork() {
        saySomething();
        this.workerStatus = WorkerStatus.WORKS;
    }

    /**
     * Сказать, отправляясь на работу.
     */
    private void saySomething() {
        log.info(QUOTES[random.nextInt(66) % QUOTES.length]);
    }

}
