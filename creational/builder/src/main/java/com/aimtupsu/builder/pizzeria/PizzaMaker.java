package com.aimtupsu.builder.pizzeria;

import com.aimtupsu.builder.pizzeria.menu.PizzaMenu;
import com.aimtupsu.builder.pizzeria.pizza.Pizza;
import com.aimtupsu.builder.pizzeria.pizza.PizzaBuilder;
import com.aimtupsu.builder.pizzeria.pizza.parts.Dough;
import com.aimtupsu.builder.pizzeria.pizza.parts.Ingredient;
import com.aimtupsu.builder.pizzeria.pizza.parts.Sauce;
import lombok.Data;

/**
 * Волшебная печь по производству пицц.
 *
 * @author Vladimir.Shchepin
 */
@Data
public class PizzaMaker {

    private final PizzaBuilder pizzaBuilder;

    /**
     * Создаёт выбранную из меню пиццу.
     */
    public Pizza makePizza(final PizzaMenu pizza) {
        switch (pizza) {
            case MARGHERITA:
                return makeMargherita();
            case PEPPERONI:
                return makePepperoni();
            case DIABOLA:
                return makeDiabola();
            default:
                return makeBranded();
        }
    }

    /**
     * Создаёт пиццу - Маргарита.
     */
    private Pizza makeMargherita() {
        return pizzaBuilder
                .name(PizzaMenu.MARGHERITA.getName())
                .dough(Dough.THIN)
                .sauce(Sauce.CATSUP)
                .ingredient(Ingredient.TOMATO)
                .ingredient(Ingredient.MOZZARELLA)
                .ingredient(Ingredient.SPICE)
                .build();
    }

    /**
     * Создаёт пиццу - Пепперони.
     */
    private Pizza makePepperoni() {
        return pizzaBuilder
                .name(PizzaMenu.PEPPERONI.getName())
                .dough(Dough.TRADITIONAL)
                .sauce(Sauce.CATSUP)
                .ingredient(Ingredient.SALAMI)
                .ingredient(Ingredient.MOZZARELLA)
                .ingredient(Ingredient.CHILLI)
                .ingredient(Ingredient.SPICE)
                .build();
    }

    /**
     * Создаёт пиццу - Дьябола.
     */
    private Pizza makeDiabola() {
        return pizzaBuilder
                .name(PizzaMenu.DIABOLA.getName())
                .dough(Dough.THIN)
                .sauce(Sauce.CATSUP)
                .ingredient(Ingredient.SALAMI)
                .ingredient(Ingredient.MUSHROOMS)
                .ingredient(Ingredient.MOZZARELLA)
                .ingredient(Ingredient.CHILLI)
                .ingredient(Ingredient.SPICE)
                .build();
    }

    /**
     * Создаёт фирменную пиццу - по умолчанию.
     */
    private Pizza makeBranded() {
        return pizzaBuilder
                .sauce(Sauce.CATSUP)
                .sauce(Sauce.MAYONNAISE)
                .ingredient(Ingredient.CHICKEN)
                .ingredient(Ingredient.MUSHROOMS)
                .ingredient(Ingredient.CHEESE)
                .ingredient(Ingredient.SPICE)
                .build();
    }

}
