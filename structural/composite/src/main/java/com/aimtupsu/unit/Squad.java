package com.aimtupsu.unit;

/**
 * Интерфейс боевого отряда.
 */
public interface Squad<T extends Unit> {

    /**
     * Добавляет в отряд данного боевого юнита.
     * @param unit юнит.
     */
    void add(T unit);

    /**
     * Удаляет из отряда данного боевого юнита.
     * @param unit юнит.
     * @return {@code true}, если в отряде был такой юнит и его удалили, иначе {@code false}.
     */
    boolean remove(T unit);

}
