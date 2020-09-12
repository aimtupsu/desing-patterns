package com.aimtupsu.workshop;

import com.aimtupsu.guitar.Guitar;
import javax.annotation.Nonnull;

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
    @Nonnull
    Guitar createGuitar();
}
