package com.aimtupsu.creational.factorymethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@RequiredArgsConstructor
public class AcousticGuitar implements Guitar{

    /**
     * Количество струн.
     */
    private final int stringCount;

    public void play() {
        log.info("Игра на акустической гитаре.");
    }
}
