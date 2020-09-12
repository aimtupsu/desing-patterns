package com.aimtupsu;

import com.aimtupsu.guitar.Guitar;
import com.aimtupsu.workshop.GuitarWorkshop;
import com.aimtupsu.workshop.impl.ClassicGuitarWorkshop;
import com.aimtupsu.workshop.impl.BassGuitarWorkshop;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {

    private static final String SPLIT_LINE = ":::::::::::::::::::::::::::::::::::::::::::";

    public static void main(String[] args) {

        log.info(SPLIT_LINE);
        log.info("\t\t\tФабричный метод");

        log.info(SPLIT_LINE);
        log.info("\tСоздание акустической гитары.");
        log.info(SPLIT_LINE);

        final GuitarWorkshop acousticGuitarWorkshop = new ClassicGuitarWorkshop();
        final Guitar acousticGuitar = acousticGuitarWorkshop.createGuitar();
        acousticGuitar.play();

        log.info(SPLIT_LINE);
        log.info("\tСоздание басс гитары.");
        log.info(SPLIT_LINE);

        final GuitarWorkshop bassGuitarWorkshop = new BassGuitarWorkshop();
        final Guitar bassGuitar = bassGuitarWorkshop.createGuitar();
        bassGuitar.play();

        log.info(SPLIT_LINE);
    }
}
