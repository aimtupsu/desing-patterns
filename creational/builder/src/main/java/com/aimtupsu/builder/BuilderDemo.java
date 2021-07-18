package com.aimtupsu.builder;

import com.aimtupsu.builder.client.Client;
import com.aimtupsu.builder.pizzeria.Pizzeria;
import com.aimtupsu.builder.pizzeria.menu.PizzaName;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;

/**
 * @author Vladimir.Shchepin
 */
@Log4j2
public class BuilderDemo {

    private static final Random RANDOM = new Random();
    private static final List<String> CLIENT_NAMES
            = new LinkedList<>(Arrays.asList("Рон", "Гарри", "Гермиона", "Невилл"));

    public static void main(String[] args) {
        log.info("Builder");

        final Pizzeria pizzeria = new Pizzeria("Потапыч");

        final List<PizzaName> menu = pizzeria.getMenu();
        final String menuStr = menu.stream().map(PizzaName::getName).collect(Collectors.joining(", "));
        log.info("Пиццерия: {}", pizzeria.getName());
        log.info("Меню пиццерии: {}", menuStr);

        CLIENT_NAMES.stream()
                .map(Client::new)
                .forEach(client -> client.buyPizza(pizzeria, getRandomPizzaName(menu)));
    }

    private static PizzaName getRandomPizzaName(final List<PizzaName> menu) {
        return menu.remove(RANDOM.nextInt(menu.size()));
    }

}
