package com.aimtupsu.creational.factorymethod;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nonnull;

/**
 * Мастерская, в которой создают басс гитары.
 *
 * @author Vladimir.Shchepin
 */
@Slf4j
public class BassGuitarWorkshop implements GuitarWorkshop {

    /**
     * Количество струн у басс гитары.
     */
    private static final int STRING_COUNT = 4;

    public BassGuitarWorkshop() {
        log.info("Создание мастерской басс гитар.");
    }

    @Override
    @Nonnull
    public Guitar createGuitar() {
        log.info("Создание новой басс гитары.");
        return new BassGuitar(STRING_COUNT);
    }
}
