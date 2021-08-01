package com.aimtupsu.config.impl;

import com.aimtupsu.config.RestClientConfig;
import lombok.Data;

/**
 * Реализация {@link RestClientConfig}.
 */
@Data
public class RestClientConfigImpl implements RestClientConfig {

    /**
     * Признак вкл/выкл логирования запросов/ответов в REST клиенте.
     */
    private final boolean logging;
    /**
     * Признак вкл/выкл записывания в БД запросов/ответов в REST клиенте.
     */
    private final boolean dbWriting;

    @Override
    public boolean isLoggingEnabled() {
        return logging;
    }

    @Override
    public boolean isDbWritingEnabled() {
        return dbWriting;
    }

}
