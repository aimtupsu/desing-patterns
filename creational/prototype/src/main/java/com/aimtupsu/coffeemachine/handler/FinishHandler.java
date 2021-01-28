package com.aimtupsu.coffeemachine.handler;

import com.aimtupsu.coffeemachine.state.State;

public class FinishHandler implements Handler {

    @Override
    public State handle(final State state) {
        state.setReady(true);
        return state;
    }

}
