package com.aimtupsu.coffeemachine.instruction;

import com.aimtupsu.coffeemachine.handler.Handler;
import com.aimtupsu.coffeemachine.handler.HandlerFactory;
import com.aimtupsu.coffeemachine.handler.exception.HandleException;
import com.aimtupsu.coffeemachine.state.Receipt;
import com.aimtupsu.coffeemachine.state.State;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
public class StartInstruction implements Instruction {

    private static final Map<Integer, Receipt> RECEIPT_MAP = Map.of(
            1, Receipt.CAPPUCCINO,
            2, Receipt.LATTE,
            3, Receipt.AMERICANO,
            4, Receipt.ESPRESSO
    );

    private static final List<Handler> HANDLERS = List.of(
            HandlerFactory.getCoffeeHandler(),
            HandlerFactory.getWaterHandler(),
            HandlerFactory.getCupHandler(),
            HandlerFactory.getMilkHandler()
    );

    @Getter
    private State state;

    @Override
    public void showMessage() {
        log.info("[Coffee Machine] - Запустился процесс приготовления кофе.");
        log.info("[Coffee Machine] - Пожалуйста выберете напиток.");
        log.info("[Coffee Machine] - 1 - Каппучино.");
        log.info("[Coffee Machine] - 2 - Латте.");
        log.info("[Coffee Machine] - 3 - Американо.");
        log.info("[Coffee Machine] - 4 - Эспрессо.");
    }

    @Override
    public void inputData(int data) {
        final Receipt currentReceipt = RECEIPT_MAP.get(data);
        log.info("[Coffee Machine] - Выбран напиток - {}", currentReceipt.toString());
        state.setCurrentReceipt(currentReceipt);
    }

    @Override
    public Instruction next() throws HandleException {
        if (state.getCurrentReceipt() == null) {
            log.error("[Coffee Machine] - Ошибка! Вы не выбрали напиток.");
            return this;
        }
        for (Handler handler : HANDLERS) {
            state = handler.handle(this.state);
        }
        return new SugarInstruction(state);
    }

}
