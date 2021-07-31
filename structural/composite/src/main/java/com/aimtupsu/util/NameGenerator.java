package com.aimtupsu.util;

import java.util.Random;
import lombok.experimental.UtilityClass;

@UtilityClass
public class NameGenerator {

    private final static Random R = new Random();
    private final static int UNIT_NAME_COUNT = 6;
    private final static int SQUAD_NAME_COUNT = 3;
    private final static String[] UNIT_NAMES = new String[UNIT_NAME_COUNT];
    private final static String[] SQUAD_NAMES = new String[SQUAD_NAME_COUNT];

    static {
        UNIT_NAMES[0] = "John";     UNIT_NAMES[1] = "Altair";   UNIT_NAMES[2] = "Alister";
        UNIT_NAMES[3] = "Bangkoh";  UNIT_NAMES[4] = "Putin";    UNIT_NAMES[5] = "Roman";
        SQUAD_NAMES[0] = "Freaks";  SQUAD_NAMES[1] = "Mads";    SQUAD_NAMES[2] = "Reservoir Dogs";
    }

    String generateUnitName() {
        return UNIT_NAMES[R.nextInt(UNIT_NAME_COUNT)];
    }

    String generateSquadName() {
        return SQUAD_NAMES[R.nextInt(SQUAD_NAME_COUNT)];
    }

}
