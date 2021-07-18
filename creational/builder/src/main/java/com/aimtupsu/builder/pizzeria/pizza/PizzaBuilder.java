package com.aimtupsu.builder.pizzeria.pizza;

import com.aimtupsu.builder.pizzeria.menu.PizzaName;
import com.aimtupsu.builder.pizzeria.pizza.parts.Dough;
import com.aimtupsu.builder.pizzeria.pizza.parts.Ingredient;
import com.aimtupsu.builder.pizzeria.pizza.parts.Sauce;

/**
 * Строитель пиццы.
 *
 * @author Vladimir.Shchepin
 */
public interface PizzaBuilder {

    /**
     * Сбрасывает постройку пиццы до начального состояния.
     */
    PizzaBuilder reset();

    /**
     * Проставляет название создаваемой пиццы.
     *
     * @param name будущее название пиццы.
     * @return самого себя.
     */
    PizzaBuilder name(PizzaName name);

    /**
     * Проставляет вид теста для создаваемой пиццы.
     *
     * @param dough тесто будущей пиццы.
     * @return самого себя.
     */
    PizzaBuilder dough(Dough dough);

    /**
     * Проставляет соус для создаваемой пиццы.
     *
     * @param sauce соус для будущей пиццы.
     * @return самого себя.
     */
    PizzaBuilder sauce(Sauce sauce);

    /**
     * Проставляет ингредиент для создаваемой пиццы.
     *
     * @param ingredient ингредиент для будущей пиццы.
     * @return самого себя.
     */
    PizzaBuilder ingredient(Ingredient ingredient);

    /**
     * Конечная стадия постройки пиццы.
     * Создаёт новый объект пиццы со всеми параметрами, проставленными заранее.
     *
     * @return новая пицца.
     */
    Pizza build();

}
