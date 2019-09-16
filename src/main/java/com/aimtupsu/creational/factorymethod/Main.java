package com.aimtupsu.creational.factorymethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        log.info("<++++FABRIC METHOD++++>");

        final AcousticGuitarWorkshop acousticGuitarWorkshop = new AcousticGuitarWorkshop();

        final Guitar acousticGuitar = acousticGuitarWorkshop.createGuitar();

        acousticGuitar.play();

        final BassGuitarWorkshop bassGuitarWorkshop = new BassGuitarWorkshop();

        final Guitar bassGuitar = bassGuitarWorkshop.createGuitar();

        bassGuitar.play();

        log.info("<+++++FABRIC METHOD+++++>");
    }
}
