package com.aimtupsu.builder.client;

import com.aimtupsu.builder.pizzeria.Pizzeria;
import com.aimtupsu.builder.pizzeria.menu.PizzaMenu;
import com.aimtupsu.builder.pizzeria.pizza.Pizza;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Клиент пиццерии.
 *
 * @author Vladimir.Shchepin
 */
@Log4j2
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Client {

    private final String name;
    private final PizzaMenu pizzaMenu;

    /**
     * Покупает пиццу в пиццерии - {@link Pizzeria};
     */
    public void buyPizza(final Pizzeria pizzeria) {
        log.info("Клиент {} покупает пиццу.", name);

        final Pizza pizza = pizzeria.makePizza(this.pizzaMenu);

        log.info("Клиент {} купил пиццу: \n{}", name, pizza.getDescription());
    }

}
