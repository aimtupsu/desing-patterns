package com.aimtupsu.builder.pizzeria.pizza;

import com.aimtupsu.builder.pizzeria.menu.PizzaName;
import com.aimtupsu.builder.pizzeria.pizza.parts.Dough;
import com.aimtupsu.builder.pizzeria.pizza.parts.Ingredient;
import com.aimtupsu.builder.pizzeria.pizza.parts.Sauce;
import java.util.List;

/**
 * @author Vladimir.Shchepin
 */
public interface Pizza {

    /**
     * Возвращает название пиццы.
     */
    PizzaName getName();

    /**
     * Возвращает подробное описание пиццы.
     */
    String getDescription();

    /**
     * Возвращает вид теста пиццы.
     */
    Dough getDough();

    /**
     * Возвращает список соусов, добавленных в пиццу.
     */
    List<Sauce> getSauces();

    /**
     * Возвращает список ингредиентов, добавленных в пиццу.
     */
    List<Ingredient> getIngredients();

}
