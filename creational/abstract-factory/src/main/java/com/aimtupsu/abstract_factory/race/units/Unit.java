package com.aimtupsu.abstract_factory.race.units;

/**
 * @author Vladimir.Shchepin
 */
public interface Unit {

    /**
     * Вызывается при создании юнита.
     */
    void onCreate();

    /**
     * Вызывается при выборе юнита.
     */
    void onSelect();

}
