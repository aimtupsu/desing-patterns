package com.aimtupsu.builder;

import com.aimtupsu.builder.client.Client;
import com.aimtupsu.builder.pizzeria.Pizzeria;
import com.aimtupsu.builder.pizzeria.menu.PizzaMenu;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import lombok.extern.log4j.Log4j2;

/**
 * @author Vladimir.Shchepin
 */
@Log4j2
public class BuilderDemo {

    private static Random r = new Random();
    private static List<String> clientNames = new LinkedList<>(Arrays.asList("Рон", "Гарри", "Гермиона", "Невилл"));

    public static void main(String[] args) {
        log.info("Builder");

        final Pizzeria pizzeria = new Pizzeria("Потапыч");

        final List<String> menu = pizzeria.getMenu();
        log.info("Пиццерия: {}", pizzeria.getName());
        log.info("Меню пиццерии: {}", String.join(", ", menu));

        Arrays.stream(PizzaMenu.values())
                .map(m -> new Client(generateClientName(), m))
                .forEach(c -> c.buyPizza(pizzeria));
    }

    private static String generateClientName() {
        return clientNames.remove(r.nextInt(clientNames.size()));
    }

}
