package com.aimtupsu.decorator;

import com.aimtupsu.client.RestClient;
import com.aimtupsu.model.rest.Request;
import com.aimtupsu.model.rest.Response;
import javax.annotation.Nonnull;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoggingRestClient extends RestClientDecorator {

    public LoggingRestClient(final RestClient restClient) {
        super(restClient);
    }

    @Nonnull
    @Override
    public Response send(Request request) {
        log.info("Request: {} sent.", request);
        final Response response = restClient.send(request);
        log.info("Received a response: {}", response);
        return response;
    }

}
