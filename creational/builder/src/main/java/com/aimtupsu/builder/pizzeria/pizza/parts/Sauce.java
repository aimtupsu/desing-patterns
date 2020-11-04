package com.aimtupsu.builder.pizzeria.pizza.parts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Vladimir.Shchepin
 */
@RequiredArgsConstructor
public enum Sauce {

    CATSUP("Томатный"),
    MAYONNAISE("Майонез")
    ;

    @Getter
    private final String name;
}
