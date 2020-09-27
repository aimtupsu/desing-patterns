package com.aimtupsu.abstract_factory.race.impl.human.warrior;

import com.aimtupsu.abstract_factory.race.units.warrior.Warrior;
import com.aimtupsu.abstract_factory.race.units.warrior.parameters.WarriorStatus;
import java.util.Random;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Пехотинец. Воин Альянса.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@EqualsAndHashCode
@ToString
public class Footman implements Warrior {

    private static final String CREATE_QUOTE = "Ready for action.";
    private static final String[] SELECT_QUOTES = {
            "Orders?",
            "What do you need?",
            "Yes, my liege?",
            "Say the word."
    };
    private static final String[] ATTACK_QUOTES = {
            "Let me at 'em!",
            "Attack!",
            "To arms!",
            "For Lordaeron!"
    };

    @Getter
    private WarriorStatus warriorStatus;
    private final Random random = new Random();

    public Footman() {
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
