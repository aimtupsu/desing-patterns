package com.aimtupsu.singleton.counter.impl.lazy.synchronised;

import com.aimtupsu.singleton.counter.Counter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Синхронизированная версия singleton-счётчика.
 * <p>
 * Поддерживает ленивую инициализацию.
 * Экземпляр создаётся вручную, с помощью статического,
 * синхронизованного метода {@link SyncCounter#getInstance()}.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@EqualsAndHashCode
@ToString
public class SyncCounter implements Counter {

    private static SyncCounter instance;

    private int counter;

    private SyncCounter() {
        log.info("Synchronized counter is created.");
    }

    /**
     * Возвращает единственный экземпляр этого класса.
     * Для потокобезопасноти метод синхронизирован.
     */
    public static synchronized SyncCounter getInstance() {
        if (instance == null) {
            instance = new SyncCounter();
        }
        return instance;
    }

    @Override
    public void increment() {
        counter++;
    }

    @Override
    public int total() {
        return counter;
    }

}
