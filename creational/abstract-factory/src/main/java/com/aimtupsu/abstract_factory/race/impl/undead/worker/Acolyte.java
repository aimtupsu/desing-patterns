package com.aimtupsu.abstract_factory.race.impl.undead.worker;

import com.aimtupsu.abstract_factory.race.units.worker.GoldMiner;
import com.aimtupsu.abstract_factory.race.units.worker.parameters.WorkerStatus;
import java.util.Random;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Послушник. Рабочий армии Тьмы.
 * Умеет добывать золото.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@ToString
@EqualsAndHashCode
public class Acolyte implements GoldMiner {

    private static final String CREATE_QUOTE = "The damned stand ready...";
    private static final String[] SELECT_QUOTES = {
            "My life for Ner'zhul.",
            "I wish only to serve.",
            "Thy bidding, master?",
            "Where shall my blood be spilled?",
            "I bow to your will."
    };
    private static final String[] WORK_QUOTES = {
            "Yes, master.",
            "I gladly obey.",
            "My fate is sealed.",
            "Thy will be done."
    };

    @Getter
    private WorkerStatus workerStatus;
    private final Random random = new Random();

    public Acolyte() {
        this.workerStatus = WorkerStatus.READY;
    }

    @Override
    public void mineGold() {
        log.info(WORK_QUOTES[random.nextInt(66) % WORK_QUOTES.length]);
        this.workerStatus = WorkerStatus.WORKS;
    }

    @Override
    public void onCreate() {
        log.info(CREATE_QUOTE);
    }

    @Override
    public void onSelect() {
        log.info(SELECT_QUOTES[random.nextInt(55) % SELECT_QUOTES.length]);
    }

}
