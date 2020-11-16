package com.aimtupsu.singleton.handler;

import com.aimtupsu.singleton.counter.Counter;
import com.aimtupsu.singleton.request.Request;
import java.util.function.Supplier;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * Обработчик запросов.
 * Имитирует обработку запросов (на самом деле просто отправляет поток в сон).
 * Подсчитывает количество запросов с ошибкой.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@Data
public class RequestHandler implements Runnable {

    private final Supplier<Counter> counterSupplier;
    private final Request request;

    @Override
    public void run() {
        log.trace("Thread {} is started.", Thread.currentThread().getName());
        handle();
        log.trace("Thread {} is stopped.", Thread.currentThread().getName());
    }

    private void handle() {
        log.info("Handling request - {}", request);
        try {
            Thread.sleep(100);
            if (request.getType() == Request.RequestType.ERROR) {
                log.warn("Error request. Increment counter.");
                counterSupplier.get().increment();
            }
        } catch (InterruptedException e) {
            log.error("Error!", e);
        }
    }

}
