package com.aimtupsu.builder.pizzeria;

import com.aimtupsu.builder.pizzeria.menu.PizzaMenu;
import com.aimtupsu.builder.pizzeria.pizza.Pizza;
import com.aimtupsu.builder.pizzeria.pizza.PizzaBuilder;
import com.aimtupsu.builder.pizzeria.pizza.impl.PizzaBuilderImpl;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
    public List<String> getMenu() {
        return Arrays.stream(PizzaMenu.values())
                .map(PizzaMenu::getName)
                .collect(Collectors.toList());
    }

    /**
     * Готовит выбранную из меню пиццу.
     */
    public Pizza makePizza(final PizzaMenu pizza) {
        return pizzaMaker.makePizza(pizza);
    }

}
