package com.aimtupsu.bankclient.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OperationType {

    PAY(1),
    REFUND(-1);

    private final int sign;
}
