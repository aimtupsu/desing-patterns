package com.aimtupsu.creational.factorymethod;

public class BassGuitarWorkshop implements GuitarWorkshop {

    @Override
    public Guitar createGuitar() {

        final BassGuitar bassGuitar = new BassGuitar();

        bassGuitar.setStringCount(4);

        return bassGuitar;
    }
}
