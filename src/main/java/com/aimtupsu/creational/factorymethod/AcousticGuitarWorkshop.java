package com.aimtupsu.creational.factorymethod;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nonnull;

/**
 * Мастерская, в которой создают акустические гитары.
 *
 * @author Vladimir.Shchepin
 */
@Slf4j
public class AcousticGuitarWorkshop implements GuitarWorkshop {

    /**
     * Количество струн у акустической гитары.
     */
    private static final int STRING_COUNT = 4;

    public AcousticGuitarWorkshop() {
        log.info("Создание мастерской акустических гитар.");
    }

    @Override
    @Nonnull
    public Guitar createGuitar() {
        log.info("Создание новой акустической гитары.");
        return new AcousticGuitar(STRING_COUNT);
    }
}