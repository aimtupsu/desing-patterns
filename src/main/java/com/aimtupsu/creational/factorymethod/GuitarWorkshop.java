package com.aimtupsu.creational.factorymethod;

import javax.annotation.Nonnull;

/**
 * Интерфейс мастерской, в которой создают гитары.
 *
 * @author Vladimir.Shchepin
 */
public interface GuitarWorkshop {

    /**
     * Создаёт гитару - {@link Guitar}.
     *
     * @return  объект гитары.
     */
    @Nonnull
    Guitar createGuitar();
}
