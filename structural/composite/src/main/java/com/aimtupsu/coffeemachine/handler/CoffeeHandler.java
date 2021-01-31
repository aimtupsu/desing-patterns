package com.aimtupsu.coffeemachine.handler;

import com.aimtupsu.coffeemachine.handler.exception.HandleException;
import com.aimtupsu.coffeemachine.state.Quantity;
import com.aimtupsu.coffeemachine.state.State;
import com.aimtupsu.coffeemachine.utils.QuantityComparator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CoffeeHandler implements Handler {

    @Override
    public State handle(State state) throws HandleException {
        final Quantity requiredCoffeeQuantity = state.getCurrentReceipt().getCoffee();
        final Quantity currentCoffeeQuantity = state.getCoffee();
        final QuantityComparator comparator = QuantityComparator.COMPARATOR;

        if (comparator.isLessThan(currentCoffeeQuantity, requiredCoffeeQuantity)) {
            throw new HandleException("Кофе в машине меньше чем требутеся для приготовления напитка.");
        }

        currentCoffeeQuantity.decrease(requiredCoffeeQuantity);

        return state;
    }

}
