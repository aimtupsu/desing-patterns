package com.aimtupsu.guitar.impl;

import com.aimtupsu.guitar.Guitar;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * Басс гитара.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@Data
public class BassGuitar implements Guitar {

    /**
     * Количество струн.
     */
    private final int stringCount;

    @Override
    public void play() {
        log.info("Игра на басс гитаре.");
    }
}