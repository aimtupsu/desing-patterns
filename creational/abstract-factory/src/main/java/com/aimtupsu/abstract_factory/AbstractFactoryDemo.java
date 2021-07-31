package com.aimtupsu.abstract_factory;

import com.aimtupsu.abstract_factory.player.Player;
import com.aimtupsu.abstract_factory.player.PlayerEmulator;
import com.aimtupsu.abstract_factory.race.Race;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.log4j.Log4j2;

/**
 * @author Vladimir.Shchepin
 */
@Log4j2
public class AbstractFactoryDemo {

    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(Race.values().length);

    public static void main(String[] args) throws InterruptedException {

        log.info("Абстрактная фабрика");

        final List<Thread> playerThreads = Stream.of(Race.values())
                .map(AbstractFactoryDemo::createPlayer)
                .map(AbstractFactoryDemo::createPlayerEmulator)
                .map(AbstractFactoryDemo::createThread)
                .collect(Collectors.toList());

        playerThreads.forEach(Thread::start);

        COUNT_DOWN_LATCH.await();
    }

    private static Player createPlayer(final Race race) {
        return new Player("Player-" + race.name(), race);
    }

    private static PlayerEmulator createPlayerEmulator(final Player player) {
        return new PlayerEmulator(player, AbstractFactoryDemo.COUNT_DOWN_LATCH);
    }

    private static Thread createThread(final PlayerEmulator playerEmulator) {
        return new Thread(playerEmulator, "Thread-" + playerEmulator.getPlayer().getName());
    }

}
