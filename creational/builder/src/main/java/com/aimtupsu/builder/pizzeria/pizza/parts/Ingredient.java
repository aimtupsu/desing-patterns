package com.aimtupsu.builder.pizzeria.pizza.parts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Vladimir.Shchepin
 */
@RequiredArgsConstructor
public enum Ingredient {

    MUSHROOMS("Грибы"),
    CHEESE("Сыр"),
    MOZZARELLA("Сыр Моцарелла"),
    SPICE("Специи"),
    CHICKEN("Курица"),
    SALAMI("Салями"),
    CHILLI("Перец чили"),
    TOMATO("Томаты")
    ;

    @Getter
    private final String name;
}
