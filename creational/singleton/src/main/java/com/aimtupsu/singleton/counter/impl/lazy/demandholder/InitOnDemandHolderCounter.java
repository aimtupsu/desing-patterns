package com.aimtupsu.singleton.counter.impl.lazy.demandholder;

import com.aimtupsu.singleton.counter.Counter;
import com.aimtupsu.singleton.counter.impl.notlazy.statical.StaticCounter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Singleton-счётчик, реализующий идиому "Владелец инициализации по требованию".
 * <p>
 * Реализация похожа на статическую версию singleton ({@link StaticCounter})
 * но с поддержкой ленивой инициализации.
 * <p>
 * Из-за того, что экземпляр singleton хранится не в самом классе singleton,
 * а в статическом финальном поле приватного внутреннего класса {@link CounterHolder},
 * инициализация экземпляра происходит не в момент загрузки класса {@link InitOnDemandHolderCounter},
 * а в момент первого обращения к классу {@link CounterHolder}.
 * В нашем случае первое обращение к классу {@link CounterHolder}
 * происходит в методе {@link InitOnDemandHolderCounter#getInstance()}.
 * Потокобезопасность достигается тем же самым механизмом - статическое поле инициализируется
 * один раз, при первой загрузке класса.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@EqualsAndHashCode
@ToString
public class InitOnDemandHolderCounter implements Counter {

    private int counter;

    private InitOnDemandHolderCounter() {
        log.info("Initialization-on-demand holder counter is created.");
    }

    /**
     * Возравращает единственный экземпляр singleton-счётчика.
     */
    public static InitOnDemandHolderCounter getInstance() {
        return CounterHolder.INSTANCE;
    }

    @Override
    public void increment() {
        counter++;
    }

    @Override
    public int total() {
        return counter;
    }

    /**
     * Держатель экземпляра singleton - {@link InitOnDemandHolderCounter}.
     */
    private static class CounterHolder {
        static final InitOnDemandHolderCounter INSTANCE = new InitOnDemandHolderCounter();
    }

}
