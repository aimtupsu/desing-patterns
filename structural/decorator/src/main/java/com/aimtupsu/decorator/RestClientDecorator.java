package com.aimtupsu.decorator;

import com.aimtupsu.client.RestClient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Декоратор REST клиента - {@link RestClient}.
 */
@RequiredArgsConstructor
public abstract class RestClientDecorator implements RestClient {

    /**
     * REST клиент, который расширяют.
     */
    @Getter
    protected final RestClient restClient;

}
