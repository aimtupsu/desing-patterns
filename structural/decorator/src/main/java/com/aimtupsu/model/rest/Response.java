package com.aimtupsu.model.rest;

import lombok.Data;

/**
 * REST ответ.
 */
@Data
public class Response {

    private final String header;
    private final String body;

}
