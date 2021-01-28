package com.aimtupsu.coffeemachine;

import com.aimtupsu.coffeemachine.state.Quantity;
import com.aimtupsu.coffeemachine.state.State;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CoffeeMachineFactory {

    public CoffeeMachine getCoffeeMachine() {
        return new CoffeeMachine(getState());
    }

    private State getState() {
        return new State(
                Quantity.getQuantityInGram(3000),
                Quantity.getQuantityInMilliliter(5000),
                Quantity.getQuantityInMilliliter(3000),
                Quantity.getQuantityInGram(1000),
                Quantity.getQuantityInPieces(300)
        );
    }

}
