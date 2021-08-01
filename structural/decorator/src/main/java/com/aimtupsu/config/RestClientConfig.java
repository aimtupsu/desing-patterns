package com.aimtupsu.config;

/**
 * Конфигурация REST-клиента.
 */
public interface RestClientConfig {

    /**
     * @return {@code true}, если в клиенте нужно включить логирование запросов/ответов,
     * иначе {@code false}.
     */
    boolean isLoggingEnabled();

    /**
     * @return {@code true}, если в клиенте нужно включить записывание запросов/ответов в базу данных,
     * иначе {@code false}.
     */
    boolean isDbWritingEnabled();

}
