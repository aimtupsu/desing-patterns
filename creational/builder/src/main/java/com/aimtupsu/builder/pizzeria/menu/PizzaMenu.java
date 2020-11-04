package com.aimtupsu.builder.pizzeria.menu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Меню пиццерии.
 *
 * @author Vladimir.Shchepin
 */
@RequiredArgsConstructor
public enum PizzaMenu {

    MARGHERITA("Маргарита"),
    PEPPERONI("Пепперони"),
    DIABOLA("Дьябола"),
    BRANDED("Фирменная")
    ;

    @Getter
    private final String name;
}
