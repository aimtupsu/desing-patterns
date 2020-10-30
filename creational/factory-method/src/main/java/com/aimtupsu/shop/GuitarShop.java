package com.aimtupsu.shop;

import com.aimtupsu.guitar.Guitar;

/**
 * Магазин гитар.
 *
 * @author Vladimir.Shchepin
 */
public interface GuitarShop {

    /**
     * Продаёт акустическую гитару.
     */
    Guitar sellClassicGuitar();

    /**
     * Продаёт басс-гитару.
     */
    Guitar sellBassGuitar();

}
