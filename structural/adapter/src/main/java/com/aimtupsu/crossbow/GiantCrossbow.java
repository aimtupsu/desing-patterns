package com.aimtupsu.crossbow;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@EqualsAndHashCode
public class GiantCrossbow implements Crossbow {

    @Override
    public void shoot() {
       log.info("Выполнен выстрел из гигантского арбалета.");
    }

    @Override
    public String toString() {
        return "Гигантский Арбалет";
    }

}
