package com.aimtupsu.shop.impl;

import com.aimtupsu.guitar.Guitar;
import com.aimtupsu.shop.GuitarShop;
import com.aimtupsu.workshop.impl.BassGuitarWorkshop;
import com.aimtupsu.workshop.impl.ClassicGuitarWorkshop;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * Реализация {@link GuitarShop}.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@Data
public class GuitarShopImpl implements GuitarShop {

    private final ClassicGuitarWorkshop classicGuitarWorkshop;
    private final BassGuitarWorkshop bassGuitarWorkshop;

    public GuitarShopImpl() {
        classicGuitarWorkshop = new ClassicGuitarWorkshop();
        bassGuitarWorkshop = new BassGuitarWorkshop();
    }

    @Override
    public Guitar sellClassicGuitar() {
        log.info("Продажа классической гитары.");
        return classicGuitarWorkshop.createGuitar();
    }

    @Override
    public Guitar sellBassGuitar() {
        log.info("Продажа басс-гитары.");
        return bassGuitarWorkshop.createGuitar();
    }

}
