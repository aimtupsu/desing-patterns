package com.aimtupsu.abstract_factory.player;

import com.aimtupsu.abstract_factory.race.Race;
import com.aimtupsu.abstract_factory.race.RaceFactory;
import com.aimtupsu.abstract_factory.race.units.warrior.Warrior;
import com.aimtupsu.abstract_factory.race.units.warrior.parameters.WarriorStatus;
import com.aimtupsu.abstract_factory.race.units.worker.GoldMiner;
import com.aimtupsu.abstract_factory.race.units.worker.LumberWorker;
import com.aimtupsu.abstract_factory.race.units.worker.Worker;
import com.aimtupsu.abstract_factory.race.units.worker.parameters.WorkerStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * @author Vladimir.Shchepin
 */
@Log4j2
@Data
public class Player {

    private final String name;
    private final Race race;
    private final RaceFactory raceFactory;
    private final List<GoldMiner> goldMiners = new ArrayList<>();
    private final List<LumberWorker> lumberWorkers = new ArrayList<>();
    private final List<Warrior> warriors = new ArrayList<>();

    public Player(@Nonnull final String name, @Nonnull final Race race) {
        this.name = name;
        this.race = race;
        this.raceFactory = race.getFactory();
    }

    public void createGoldMiner() {
        final GoldMiner goldMiner = raceFactory.createGoldMiner();
        goldMiners.add(goldMiner);
    }

    public void createLumberWorker() {
        final LumberWorker lumberWorker = raceFactory.createLumberWorker();
        lumberWorkers.add(lumberWorker);
    }

    public void createWarrior() {
        final Warrior warrior = raceFactory.createWarrior();
        warriors.add(warrior);
    }

    @Nullable
    public GoldMiner selectFreeGoldMiner() {
        final Optional<GoldMiner> goldMinerOpt = selectFreeWorker(goldMiners);
        if (goldMinerOpt.isPresent()) {
            final GoldMiner goldMiner = goldMinerOpt.get();
            goldMiner.onSelect();
            return goldMiner;
        } else {
            log.info("No free gold miner");
            return null;
        }
    }

    @Nullable
    public LumberWorker selectFreeLumberWorker() {
        final Optional<LumberWorker> lumberWorkerOpt = selectFreeWorker(lumberWorkers);
        if (lumberWorkerOpt.isPresent()) {
            final LumberWorker lumberWorker = lumberWorkerOpt.get();
            lumberWorker.onSelect();
            return lumberWorker;
        } else {
            log.info("No free lumber worker");
            return null;
        }
    }

    @Nullable
    public Warrior selectFreeWarrior() {
        final Optional<Warrior> warOpt = warriors.stream()
                .filter(warrior -> warrior.getWarriorStatus() == WarriorStatus.READY)
                .findFirst();
        if (warOpt.isPresent()) {
            final Warrior warrior = warOpt.get();
            warrior.onSelect();
            return warrior;
        } else {
            log.info("No free warrior");
            return null;
        }
    }

    private <T extends Worker> Optional<T> selectFreeWorker(List<T> workerList) {
        return workerList.stream()
                .filter(worker -> worker.getWorkerStatus() == WorkerStatus.READY)
                .findFirst();
    }

}
