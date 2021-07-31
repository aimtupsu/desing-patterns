package com.aimtupsu.builder.client;

import com.aimtupsu.builder.pizzeria.Pizzeria;
import com.aimtupsu.builder.pizzeria.menu.PizzaName;
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

    /**
     * Покупает пиццу в пиццерии - {@link Pizzeria};
     *
     * @param pizzeria пиццерия.
     * @param pizzaName название пиццы.
     */
    public void buyPizza(final Pizzeria pizzeria, final PizzaName pizzaName) {
        log.info("Клиент {} покупает пиццу.", name);
        if (!pizzeria.getMenu().contains(pizzaName)) {
            throw new IllegalArgumentException(
                    String.format("Пиццы %s нет в меню пиццерии %s", pizzaName.getName(), pizzeria.getName())
            );
        }
        final Pizza pizza = pizzeria.makePizza(pizzaName);
        log.info("Клиент {} купил пиццу: \n{}", name, pizza.getDescription());
    }

}
