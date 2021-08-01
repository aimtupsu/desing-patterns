package com.aimtupsu.factory;

import com.aimtupsu.client.RestClient;
import com.aimtupsu.client.impl.RestClientImpl;
import com.aimtupsu.config.RestClientConfig;
import com.aimtupsu.config.impl.RestClientConfigImpl;
import com.aimtupsu.dao.Dao;
import com.aimtupsu.dao.impl.DaoImpl;
import com.aimtupsu.decorator.DbWritingRestClient;
import com.aimtupsu.decorator.LoggingRestClient;
import lombok.experimental.UtilityClass;

/**
 * Фабрика REST клиентов.
 */
@UtilityClass
public class RestClientFactory {

    /**
     * Объект доступа к БД.
     */
    private final Dao DAO = new DaoImpl();

    /**
     * Конфиг REST клиента с выключенными логированием и записыванием в БД
     */
    private final RestClientConfig DEFAULT_REST_CLIENT_CONFIG
            = new RestClientConfigImpl(false, false);
    /**
     * Конфиг REST клиента с включенным логированием, но выключенным записыванием в БД.
     */
    private final RestClientConfig LOGGING_REST_CLIENT_CONFIG
            = new RestClientConfigImpl(true, false);
    /**
     * Конфиг REST клиента с включенным записыванием в БД, но выключенным логированием.
     */
    private final RestClientConfig DB_WRITING_REST_CLIENT_CONFIG
            = new RestClientConfigImpl(false, true);
    /**
     * Конфиг REST клиента с включенными логированием и записыванием в БД.
     */
    private final RestClientConfig LOGGING_AND_DB_WRITING_REST_CLIENT_CONFIG
            = new RestClientConfigImpl(true, true);

    /**
     * Обычный REST клиент.
     */
    private final RestClient SIMPLE_REST_CLIENT
            = createRestClient(DEFAULT_REST_CLIENT_CONFIG);
    /**
     * REST клиент с логированием.
     */
    private final RestClient LOGGING_REST_CLIENT
            = createRestClient(LOGGING_REST_CLIENT_CONFIG);
    /**
     * REST клиент с записыванием в БД.
     */
    private final RestClient DB_WRITING_REST_CLIENT
            = createRestClient(DB_WRITING_REST_CLIENT_CONFIG);
    /**
     * REST клиент с логированием и записыванием в БД.
     */
    private final RestClient LOGGING_AND_DB_WRITING_REST_CLIENT
            = createRestClient(LOGGING_AND_DB_WRITING_REST_CLIENT_CONFIG);

    /**
     * @return объект доступа к БД.
     */
    public Dao getDao() {
        return DAO;
    }

    /**
     * @return обычный REST клиент.
     */
    public RestClient getSimpleRestClient() {
        return SIMPLE_REST_CLIENT;
    }

    /**
     * @return REST клиент с логированием.
     */
    public RestClient getRestClientWithLogging() {
        return LOGGING_REST_CLIENT;
    }

    /**
     * @return REST клиент с записыванием в БД.
     */
    public RestClient getRestClientWithDbWriting() {
        return DB_WRITING_REST_CLIENT;
    }

    /**
     * @return REST клиент с логированием и записыванием в БД.
     */
    public RestClient getRestClientWithLoggingAndDbWriting() {
        return LOGGING_AND_DB_WRITING_REST_CLIENT;
    }

    /**
     * Создаёт REST клиент, основываясь на конфиге.
     *
     * @param config конфиг REST клиента.
     * @return сконфигурированный REST клиент.
     */
    private RestClient createRestClient(final RestClientConfig config) {
        RestClient restClient = new RestClientImpl();
        if (config.isLoggingEnabled()) {
            restClient = new LoggingRestClient(restClient);
        }
        if (config.isDbWritingEnabled()) {
            restClient = new DbWritingRestClient(restClient, DAO);
        }
        return restClient;
    }

}
