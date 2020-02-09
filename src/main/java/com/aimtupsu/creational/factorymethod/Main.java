package com.aimtupsu.creational.factorymethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        log.info("Фабричный метод");
        log.info("Создание акустической гитары.");

        final GuitarWorkshop acousticGuitarWorkshop = new AcousticGuitarWorkshop();

        final Guitar acousticGuitar = acousticGuitarWorkshop.createGuitar();

        acousticGuitar.play();

        log.info("Создание басс гитары.");

        final GuitarWorkshop bassGuitarWorkshop = new BassGuitarWorkshop();

        final Guitar bassGuitar = bassGuitarWorkshop.createGuitar();

        bassGuitar.play();

        log.info("Фабричный метод");
    }
}
