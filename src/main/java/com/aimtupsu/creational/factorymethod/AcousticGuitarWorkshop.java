package com.aimtupsu.creational.factorymethod;

public class AcousticGuitarWorkshop implements GuitarWorkshop {

    @Override
    public Guitar createGuitar() {

        final AcousticGuitar acousticGuitar = new AcousticGuitar();

        acousticGuitar.setStringCount(6);

        return acousticGuitar;
    }
}
