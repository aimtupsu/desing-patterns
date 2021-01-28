package com.aimtupsu.coffeemachine.instruction;

import com.aimtupsu.coffeemachine.handler.exception.HandleException;
import com.aimtupsu.coffeemachine.state.State;

public interface Instruction {

    State getState();
    void showMessage();
    default void inputData(final int data) {

    }
    Instruction next() throws HandleException;

}
