package com.aimtupsu.workshop.impl;

import com.aimtupsu.guitar.Guitar;
import com.aimtupsu.guitar.impl.BassGuitar;
import com.aimtupsu.workshop.GuitarWorkshop;
import lombok.extern.log4j.Log4j2;

/**
 * Мастерская, в которой создают басс гитары.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
public class BassGuitarWorkshop implements GuitarWorkshop {

    /**
     * Количество струн у басс гитары.
     */
    private static final int STRING_COUNT = 4;

    public BassGuitarWorkshop() {
        log.info("Создание мастерской басс гитар.");
    }

    @Override
    public Guitar createGuitar() {
        log.info("Создание новой басс гитары.");
        return new BassGuitar(STRING_COUNT);
    }
}
