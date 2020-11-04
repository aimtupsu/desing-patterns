package com.aimtupsu.builder.pizzeria.pizza.parts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Vladimir.Shchepin
 */
@RequiredArgsConstructor
public enum Dough {

    TRADITIONAL("Традиционное"),
    THIN("Тонкое")
    ;

    @Getter
    private final String name;
}
