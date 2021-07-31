package com.aimtupsu.abstract_factory.race.impl.nightelf.warrior;

import com.aimtupsu.abstract_factory.race.units.warrior.Warrior;
import com.aimtupsu.abstract_factory.race.units.warrior.parameters.WarriorStatus;
import java.util.Random;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Лучница. Воин ночных эльфов.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@EqualsAndHashCode
@ToString
public class Archer implements Warrior {

    private static final String CREATE_QUOTE = "I stand ready.";
    private static final String[] SELECT_QUOTES = {
            "Waiting on you.",
            "Point the way.",
            "On your mark.",
            "Your move."
    };
    private static final String[] ATTACK_QUOTES = {
            "I'll give it a shot.",
            "Fire!",
            "One shot, one kill.",
            "Cry havoc!",
            "By the light of the moon!"
    };

    @Getter
    private WarriorStatus warriorStatus;
    private final Random random = new Random();

    public Archer() {
        this.warriorStatus = WarriorStatus.READY;
    }

    @Override
    public void attack() {
        log.info(ATTACK_QUOTES[random.nextInt(55) % ATTACK_QUOTES.length]);
        this.warriorStatus = WarriorStatus.ATTACKS;
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
