package com.aimtupsu.coffeemachine.handler;

import com.aimtupsu.coffeemachine.handler.exception.HandleException;
import com.aimtupsu.coffeemachine.state.State;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CompositeHandler implements Handler {

    @Getter
    private final List<Handler> handlers = new ArrayList<>();

    @Override
    public State handle(final State state) throws HandleException {
        State resultState = state;
        for (Handler handler : handlers) {
            resultState = handler.handle(state);
        }
        return resultState;
    }

    public void addHandler(final Handler handler) {
        handlers.add(handler);
    }

}
