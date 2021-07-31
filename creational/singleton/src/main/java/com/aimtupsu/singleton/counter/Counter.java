package com.aimtupsu.singleton.counter;

/**
 * Счётчик.
 * Умеет увеличивать счётчик и возвращать текущее значение счётчика.
 *
 * @author Vladimir.Shchepin
 */
public interface Counter {

    /**
     * Увеличивает счётчик.
     */
    void increment();

    /**
     * Возвращает текущее значение счётчика.
     */
    int total();

}
