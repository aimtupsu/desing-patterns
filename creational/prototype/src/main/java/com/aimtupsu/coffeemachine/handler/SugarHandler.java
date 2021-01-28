package com.aimtupsu.coffeemachine.handler;

import com.aimtupsu.coffeemachine.handler.exception.HandleException;
import com.aimtupsu.coffeemachine.state.Quantity;
import com.aimtupsu.coffeemachine.state.State;
import com.aimtupsu.coffeemachine.utils.QuantityComparator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SugarHandler implements Handler {

    @Override
    public State handle(State state) throws HandleException {
        final Quantity requiredSugarQuantity = state.getCurrentSugar();
        final Quantity currentSugarQuantity = state.getSugar();
        final QuantityComparator comparator = QuantityComparator.COMPARATOR;

        if (comparator.isLessThan(currentSugarQuantity, requiredSugarQuantity)) {
            throw new HandleException("Сахара в машине меньше чем требутеся для приготовления напитка.");
        }

        currentSugarQuantity.decrease(requiredSugarQuantity);

        return state;
    }

}
