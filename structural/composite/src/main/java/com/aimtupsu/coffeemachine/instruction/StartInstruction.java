package com.aimtupsu.coffeemachine.instruction;

import com.aimtupsu.coffeemachine.handler.Handler;
import com.aimtupsu.coffeemachine.handler.exception.HandleException;
import com.aimtupsu.coffeemachine.state.Receipt;
import com.aimtupsu.coffeemachine.state.State;
import java.util.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class StartInstruction implements Instruction {

    private final Map<Integer, Receipt> receiptMap;
    private final Handler handler;
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
        final Receipt currentReceipt = receiptMap.get(data);
        log.info("[Coffee Machine] - Выбран напиток - {}", currentReceipt.toString());
        state.setCurrentReceipt(currentReceipt);
    }

    @Override
    public Instruction next() throws HandleException {
        if (state.getCurrentReceipt() == null) {
            log.error("[Coffee Machine] - Ошибка! Вы не выбрали напиток.");
            return this;
        }
        state = handler.handle(this.state);
        return InstructionFactory.getSugarInstruction(state);
    }

}
