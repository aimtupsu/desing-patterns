package com.aimtupsu.coffeemachine.handler;

import com.aimtupsu.coffeemachine.handler.exception.HandleException;
import com.aimtupsu.coffeemachine.state.Quantity;
import com.aimtupsu.coffeemachine.state.State;
import com.aimtupsu.coffeemachine.utils.QuantityComparator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class WaterHandler implements Handler {

    @Override
    public State handle(State state) throws HandleException {
        final Quantity requiredWaterQuantity = state.getCurrentReceipt().getWater();
        final Quantity currentWaterQuantity = state.getWater();
        final QuantityComparator comparator = QuantityComparator.COMPARATOR;

        if (comparator.isLessThan(currentWaterQuantity, requiredWaterQuantity)) {
            throw new HandleException("Воды в машине меньше чем требутеся для приготовления напитка.");
        }

        currentWaterQuantity.decrease(requiredWaterQuantity);

        return state;
    }

}
