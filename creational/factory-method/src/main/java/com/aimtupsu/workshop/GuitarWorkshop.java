package com.aimtupsu.workshop;

import com.aimtupsu.guitar.Guitar;

/**
 * Интерфейс мастерской, в которой создают гитары.
 *
 * @author Vladimir.Shchepin
 */
public interface GuitarWorkshop {

    /**
     * Создаёт гитару.
     *
     * @return  объект гитары.
     */
    Guitar createGuitar();
}
