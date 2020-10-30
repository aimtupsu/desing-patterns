package com.aimtupsu;

import com.aimtupsu.guitar.Guitar;
import com.aimtupsu.shop.GuitarShop;
import com.aimtupsu.shop.impl.GuitarShopImpl;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class FactoryMethodDemo {

    public static void main(String[] args) {
        log.info("Фабричный метод");

        final GuitarShop guitarShop = new GuitarShopImpl();

        final Guitar classicGuitar = guitarShop.sellClassicGuitar();
        classicGuitar.play();

        final Guitar bassGuitar = guitarShop.sellBassGuitar();
        bassGuitar.play();
    }
}
