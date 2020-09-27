package com.aimtupsu.abstract_factory.player;

import com.aimtupsu.abstract_factory.race.units.warrior.Warrior;
import com.aimtupsu.abstract_factory.race.units.worker.GoldMiner;
import com.aimtupsu.abstract_factory.race.units.worker.LumberWorker;
import java.util.concurrent.CountDownLatch;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * @author Vladimir.Shchepin
 */
@Log4j2
@Data
public class PlayerEmulator  implements Runnable {

    private final Player player;
    private final CountDownLatch countDownLatch;

    @Override
    public void run() {
        log.info("Player \"{}\" has started the game", player.getName());
        play();
        log.info("Player \"{}\" has finished the game", player.getName());
        countDownLatch.countDown();
    }

    /**
     * Эмуляция игры игрока.
     */
    private void play() {
        player.createGoldMiner();
        player.createLumberWorker();
        player.createWarrior();

        final GoldMiner goldMiner = player.selectFreeGoldMiner();
        goldMiner.mineGold();

        final LumberWorker lumberWorker = player.selectFreeLumberWorker();
        lumberWorker.getLumber();

        final Warrior warrior = player.selectFreeWarrior();
        warrior.attack();
    }

}
