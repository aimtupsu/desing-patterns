package com.aimtupsu.client.impl;

import com.aimtupsu.client.RestClient;
import com.aimtupsu.model.rest.Request;
import com.aimtupsu.model.rest.Response;
import javax.annotation.Nonnull;

/**
 * Простая реализация {@link RestClient}.
 */
public class RestClientImpl implements RestClient {

    @Nonnull
    @Override
    public Response send(Request request) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Response("Response header", "Response for request: " + request);
    }

}
