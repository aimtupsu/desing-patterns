package com.aimtupsu.creational.factorymethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Басс гитара.
 *
 * @author Vladimir.Shchepin
 */
@Slf4j
@Data
@RequiredArgsConstructor
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