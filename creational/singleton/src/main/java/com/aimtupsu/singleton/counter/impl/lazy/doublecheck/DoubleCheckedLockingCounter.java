package com.aimtupsu.singleton.counter.impl.lazy.doublecheck;

import com.aimtupsu.singleton.counter.Counter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Singleton-счётчик с блокировкой с двойной проверкой.
 * <p>
 * Потокобезопасен и поддерживает ленивую инициализацию.
 * Блокировка потоков в момент создания экземпляра счётчика
 * наступает лишь в том случае, если экземпляр ещё не создан.
 * <p>
 * Реализует паттерн "Блокировка с двойной проверкой".
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@EqualsAndHashCode
@ToString
public class DoubleCheckedLockingCounter implements Counter {

    private static volatile DoubleCheckedLockingCounter instance;

    private int counter;

    private DoubleCheckedLockingCounter() {
        log.info("Double checked locking counter is created.");
    }

    /**
     * Возвращает единственный экземпляр этого класса.
     * <p>
     * Потокобезопасность достигнута синхронизацией на классе в случае,
     * если статическое поле, хранящее экземпляр singleton-счётчика, равно {@code null}.
     * <p>
     * Также из-за вероятности создания экземпляра другим потоком в момент входа в блок синхранизации,
     * значение статического поля текущего экземпляра проверяется на равенство {@code null} два раза -
     * до и после входа в блок синхронизации.
     */
    public static DoubleCheckedLockingCounter getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingCounter.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingCounter();
                }
            }
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
