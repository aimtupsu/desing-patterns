package com.aimtupsu;

import com.aimtupsu.coffeemachine.CoffeeMachine;
import com.aimtupsu.coffeemachine.CoffeeMachineFactory;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CompositeDemo {


    public static void main(String[] args) {
        final CoffeeMachine coffeeMachine = CoffeeMachineFactory.getCoffeeMachine();

        log.info("Приготовим Американо.");

        makeAmericano(coffeeMachine);

        log.info("А теперь начнём готовить капуччино, но после выбора напитка нажмём отмену.");

        cancelMakingCappuccino(coffeeMachine);
    }

    private static void makeAmericano(final CoffeeMachine coffeeMachine) {

        log.info("Состояние: {}", coffeeMachine.getState());

        log.info("Запуск приготовления кофе.");
        coffeeMachine.start();

        log.info("Состояние: {}", coffeeMachine.getState());

        log.info("Выбран напиток - 3 - Американо.");
        coffeeMachine.inputData(3);

        log.info("Состояние: {}", coffeeMachine.getState());

        log.info("Далее");
        coffeeMachine.next();

        log.info("Состояние: {}", coffeeMachine.getState());

        log.info("Выбрано 2 ложки сахара");
        coffeeMachine.inputData(2);

        log.info("Состояние: {}", coffeeMachine.getState());

        log.info("Далее");
        coffeeMachine.next();

        log.info("Состояние: {}", coffeeMachine.getState());

        log.info("Далее. Заканчиваем приготовление. Забираем наш кофе.");
        coffeeMachine.next();

        log.info("Состояние: {}", coffeeMachine.getState());
    }

    private static void cancelMakingCappuccino(final CoffeeMachine coffeeMachine) {

        log.info("Состояние: {}", coffeeMachine.getState());

        log.info("Запуск приготовления кофе");
        coffeeMachine.start();

        log.info("Состояние: {}", coffeeMachine.getState());

        log.info("Выбираем напиток - 1 - Капуччино.");
        coffeeMachine.inputData(1);

        log.info("Состояние: {}", coffeeMachine.getState());

        log.info("Далее");
        coffeeMachine.next();

        log.info("Состояние: {}", coffeeMachine.getState());

        log.info("Отменяем приготовление");
        coffeeMachine.cancel();

        log.info("Состояние: {}", coffeeMachine.getState());
    }

}
