package com.aimtupsu.creational.factorymethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
public class AcousticGuitar implements Guitar{

    private int stringCount;

    public void play() {

        log.info("Play on Acoustic Guitar");
    }
}
