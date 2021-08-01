package com.aimtupsu.model.rest;

import lombok.Data;

/**
 * REST запрос.
 */
@Data
public class Request {

    private final HttpMethod method;
    private final String header;
    private final String body;

}
