package com.aimtupsu.coffeemachine.handler;

import com.aimtupsu.coffeemachine.handler.exception.HandleException;
import com.aimtupsu.coffeemachine.state.Quantity;
import com.aimtupsu.coffeemachine.state.State;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CupHandler implements Handler {

    private static final long CUP_COUNT_FOR_ONE_DRINK = 1L;

    @Override
    public State handle(State state) throws HandleException {
        final Quantity currentCupQuantity = state.getCup();

        if (currentCupQuantity.getQuantity() < CUP_COUNT_FOR_ONE_DRINK) {
            throw new HandleException("Стаканы закончились");
        }
        currentCupQuantity.decrease(CUP_COUNT_FOR_ONE_DRINK);
        return state;
    }

}
