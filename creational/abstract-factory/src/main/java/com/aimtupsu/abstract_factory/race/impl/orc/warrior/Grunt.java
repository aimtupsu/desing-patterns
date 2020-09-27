package com.aimtupsu.abstract_factory.race.impl.orc.warrior;

import com.aimtupsu.abstract_factory.race.units.warrior.Warrior;
import com.aimtupsu.abstract_factory.race.units.warrior.parameters.WarriorStatus;
import java.util.Random;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Бугай. Воин Орды.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@EqualsAndHashCode
@ToString
public class Grunt implements Warrior {

    private static final String CREATE_QUOTE = "My life for the Horde!";
    private static final String[] SELECT_QUOTES = {
            "Yes?",
            "Huh?",
            "Master?",
            "What you want?"
    };
    private static final String[] ATTACK_QUOTES = {
            "Lok'tar!",
            "Time for killing!",
            "Hragh!",
            "For the Horde!",
            "Time to die!"
    };

    @Getter
    private WarriorStatus warriorStatus;
    private final Random random = new Random();

    public Grunt() {
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
