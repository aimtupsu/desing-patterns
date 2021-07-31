package com.aimtupsu.singleton.counter.impl.notlazy.enumeration;

import com.aimtupsu.singleton.counter.Counter;
import lombok.Getter;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Singleton-счётчик в виде константы перечисления.
 * Экземпляр единственный и создаётся при первой загрузке перечисления.
 *
 * @author Vladimir.Shchepin
 */
@ToString
public enum EnumCounter implements Counter {

    INSTANCE;

    private final Logger log = LogManager.getLogger(EnumCounter.class);

    @Getter
    private int counter = 0;

    EnumCounter() {
        log.info("EnumCounter is created");
    }

    @Override
    public void increment() {
        counter++;
    }

    public int total() {
        return counter;
    }

}
