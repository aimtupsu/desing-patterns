package com.aimtupsu.builder.pizzeria.pizza.impl;

import com.aimtupsu.builder.pizzeria.menu.PizzaName;
import com.aimtupsu.builder.pizzeria.pizza.parts.Dough;
import com.aimtupsu.builder.pizzeria.pizza.parts.Ingredient;
import com.aimtupsu.builder.pizzeria.pizza.parts.Sauce;
import com.aimtupsu.builder.pizzeria.pizza.Pizza;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

/**
 * Пицца.
 *
 * @author Vladimir.Shchepin
 */
@Data
class PizzaImpl implements Pizza {

    private final PizzaName name;
    private final Dough dough;
    private final List<Sauce> sauces;
    private final List<Ingredient> ingredients;

    @Override
    public String getDescription() {
        final String pizzaFormat =
                "Название: %s.\n"
                        + "Тесто: %s.\n"
                        + "Соусы: { %s }.\n"
                        + "Ингредиенты: { %s }.\n";
        final String sauceDesc = sauces.stream()
                .map(Sauce::getName)
                .collect(Collectors.joining(", "));
        final String ingredientsDesc = ingredients.stream()
                .map(Ingredient::getName)
                .collect(Collectors.joining(", "));
        return String.format(pizzaFormat, name.getName(), dough.getName(), sauceDesc, ingredientsDesc);
    }

}
