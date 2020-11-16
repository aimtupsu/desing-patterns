package com.aimtupsu.singleton.counter.impl.notlazy.statical;

import com.aimtupsu.singleton.counter.Counter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Статическая версия singleton-счётчика.
 * <p>
 * Экземпляр счётчика иницируется при загрузке класса,
 * так как хранится в открытом свтатическом финальном поле.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@EqualsAndHashCode
@ToString
public class StaticCounter implements Counter {

    public static final StaticCounter INSTANCE = new StaticCounter();

    private int counter;

    private StaticCounter() {
        this.counter = 0;
        log.info("StaticCounter is created.");
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
