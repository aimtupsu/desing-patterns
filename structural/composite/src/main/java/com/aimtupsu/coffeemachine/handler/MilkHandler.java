package com.aimtupsu.coffeemachine.handler;

import com.aimtupsu.coffeemachine.handler.exception.HandleException;
import com.aimtupsu.coffeemachine.state.Quantity;
import com.aimtupsu.coffeemachine.state.State;
import com.aimtupsu.coffeemachine.utils.QuantityComparator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class MilkHandler implements Handler {

    @Override
    public State handle(State state) throws HandleException {
        final QuantityComparator comparator = QuantityComparator.COMPARATOR;
        final Quantity requiredMilkQuantity = state.getCurrentReceipt().getMilk();
        final Quantity currentMilkQuantity = state.getMilk();

        if (comparator.isLessThan(currentMilkQuantity, requiredMilkQuantity)) {
            throw new HandleException("Молока в машине меньше чем требутеся для приготовления напитка.");
        }

        currentMilkQuantity.decrease(requiredMilkQuantity);

        return state;
    }

}
