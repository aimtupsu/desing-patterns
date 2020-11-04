package com.aimtupsu.builder.pizzeria.pizza.impl;

import com.aimtupsu.builder.pizzeria.pizza.parts.Dough;
import com.aimtupsu.builder.pizzeria.pizza.parts.Ingredient;
import com.aimtupsu.builder.pizzeria.pizza.parts.Sauce;
import com.aimtupsu.builder.pizzeria.pizza.Pizza;
import com.aimtupsu.builder.pizzeria.pizza.PizzaBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализация {@link PizzaBuilder}.
 *
 * @author Vladimir.Shchepin
 */
public class PizzaBuilderImpl implements PizzaBuilder {

    /**
     * Значения по умолчанию.
     */
    private String name;
    private Dough dough;
    private List<Sauce> sauces;
    private List<Ingredient> ingredients;

    public PizzaBuilderImpl() {
        init();
    }

    private void init() {
        this.name = "Фирменная";
        this.dough = Dough.TRADITIONAL;
        this.sauces = new ArrayList<>();
        this.ingredients = new ArrayList<>();
    }

    @Override
    public PizzaBuilder reset() {
        init();
        return this;
    }

    @Override
    public PizzaBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PizzaBuilder dough(final Dough dough) {
        this.dough = dough;
        return this;
    }

    /**
     * В нашей реализации строителя соус не один.
     * Каждый новый соус добавляется в список соусов.
     *
     * @param sauce соус для будущей пиццы.
     * @return самого себя.
     */
    @Override
    public PizzaBuilder sauce(final Sauce sauce) {
        this.sauces.add(sauce);
        return this;
    }

    /**
     * В нашей реализации строителя ингредиент не один.
     * Каждый новый ингредиент добавляется в список ингредиентов.
     *
     * @param ingredient ингредиент для будущей пиццы.
     * @return самого себя.
     */
    @Override
    public PizzaBuilder ingredient(final Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    @Override
    public Pizza build() {
        final PizzaImpl pizza = new PizzaImpl(name, dough, sauces, ingredients);
        init();
        return pizza;
    }

}
