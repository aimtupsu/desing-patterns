package com.aimtupsu.builder.pizzeria;

import com.aimtupsu.builder.pizzeria.menu.PizzaName;
import com.aimtupsu.builder.pizzeria.pizza.Pizza;
import com.aimtupsu.builder.pizzeria.pizza.PizzaBuilder;
import com.aimtupsu.builder.pizzeria.pizza.impl.PizzaBuilderImpl;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Пиццерия.
 *
 * @author Vladimir.Shchepin
 */
@EqualsAndHashCode
@ToString
public class Pizzeria {

    @Getter
    private final String name;
    private final PizzaMaker pizzaMaker;

    public Pizzeria(final String name) {
        final PizzaBuilder pizzaBuilder = new PizzaBuilderImpl();
        this.name = name;
        this.pizzaMaker = new PizzaMaker(pizzaBuilder);
    }

    /**
     * Возвращает меню пиццерии.
     */
    public List<PizzaName> getMenu() {
        return new LinkedList<>(Arrays.asList(PizzaName.values()));
    }

    /**
     * Готовит выбранную из меню пиццу.
     */
    public Pizza makePizza(final PizzaName pizza) {
        return pizzaMaker.makePizza(pizza);
    }

}
