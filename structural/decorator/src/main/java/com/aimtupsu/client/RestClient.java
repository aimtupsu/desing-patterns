package com.aimtupsu.client;

import com.aimtupsu.model.rest.Request;
import com.aimtupsu.model.rest.Response;
import javax.annotation.Nonnull;

/**
 * REST клиент для отправки запросов на сервер и получения от сервера ответа на запрос.
 */
public interface RestClient {

    @Nonnull
    Response send(Request request);

}
