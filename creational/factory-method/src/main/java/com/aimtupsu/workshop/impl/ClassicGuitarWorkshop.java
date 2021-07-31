package com.aimtupsu.workshop.impl;

import com.aimtupsu.guitar.Guitar;
import com.aimtupsu.guitar.impl.ClassicGuitar;
import com.aimtupsu.workshop.GuitarWorkshop;
import lombok.extern.log4j.Log4j2;

/**
 * Мастерская, в которой создают классические гитары.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
public class ClassicGuitarWorkshop implements GuitarWorkshop {

    /**
     * Количество струн у акустической гитары.
     */
    private static final int STRING_COUNT = 6;

    public ClassicGuitarWorkshop() {
        log.info("Создание мастерской классических гитар.");
    }

    @Override
    public Guitar createGuitar() {
        log.info("Создание новой классической гитары.");
        return new ClassicGuitar(STRING_COUNT);
    }
}