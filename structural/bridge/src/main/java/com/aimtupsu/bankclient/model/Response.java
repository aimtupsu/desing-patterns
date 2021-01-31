package com.aimtupsu.bankclient.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Response {

    private final ResponseStatus status;

    @RequiredArgsConstructor
    public enum ResponseStatus {
        SUCCESSFUL(0),
        ERROR(4);

        private final int statusCode;
    }

}
