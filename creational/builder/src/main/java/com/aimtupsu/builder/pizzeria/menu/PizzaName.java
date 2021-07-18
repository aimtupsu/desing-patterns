package com.aimtupsu.builder.pizzeria.menu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Название пиццы.
 *
 * @author Vladimir.Shchepin
 */
@RequiredArgsConstructor
public enum PizzaName {

    MARGHERITA("Маргарита"),
    PEPPERONI("Пепперони"),
    DIABOLA("Дьябола"),
    BRANDED("Фирменная")
    ;

    @Getter
    private final String name;
}
