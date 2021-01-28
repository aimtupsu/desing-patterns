package com.aimtupsu.coffeemachine.instruction;

import com.aimtupsu.coffeemachine.handler.Handler;
import com.aimtupsu.coffeemachine.handler.HandlerFactory;
import com.aimtupsu.coffeemachine.handler.exception.HandleException;
import com.aimtupsu.coffeemachine.state.Quantity;
import com.aimtupsu.coffeemachine.state.State;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
public class SugarInstruction implements Instruction {

    private static final long SUGAR_FACTOR = 5;
    private static final long SUGAR_DEFAULT = 25;

    private static final List<Handler> HANDLERS = List.of(
            HandlerFactory.getSugarHandler()
    );

    @Getter
    private State state;

    @Override
    public void showMessage() {
        log.info("[Coffee Machine] - Пожалуйста, введите желаемое количество сахара.");
    }

    @Override
    public void inputData(int data) {
        state.setCurrentSugar(Quantity.getQuantityInGram(data * SUGAR_FACTOR));
    }

    @Override
    public Instruction next() throws HandleException {
        if (state.getCurrentSugar() == null) {
            log.warn("[Coffee Machine] - Используется количество сахара по умолчанию: {}.", SUGAR_DEFAULT);
            state.setCurrentSugar(Quantity.getQuantityInGram(SUGAR_FACTOR));
        }
        for (Handler handler : HANDLERS) {
            state = handler.handle(this.state);
        }
        return new EndInstruction(state);
    }

}
