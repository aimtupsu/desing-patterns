package com.aimtupsu.coffeemachine.instruction;

import com.aimtupsu.coffeemachine.handler.Handler;
import com.aimtupsu.coffeemachine.handler.HandlerFactory;
import com.aimtupsu.coffeemachine.handler.exception.HandleException;
import com.aimtupsu.coffeemachine.state.State;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
public class EndInstruction implements Instruction {

    private static final List<Handler> HANDLERS = List.of(
            HandlerFactory.getFinishHandler()
    );

    @Getter
    private State state;

    @Override
    public void showMessage() {
        log.info("[Coffee Machine] - Финальная стадия приготовления.");
    }

    @Override
    public void inputData(int data) {
        log.info("[Coffee Machine] - В конце приготовления напитка ввод данных не поддерживается.");
    }

    @Override
    public Instruction next() throws HandleException {
        log.info("[Coffee Machine] - Выполняется приготовление напитка. Пожалуйста, подождите.");
        try {
            Thread.sleep(10000);
            for (Handler handler : HANDLERS) {
                this.state = handler.handle(this.state);
            }
        } catch (InterruptedException e) {
            log.error("[Coffee Machine] - Ошибка во время приготовления напитка.");
        }
        log.info(
                "[Coffee Machine] - Напиток - {} приготовлен. Можете его забрать.",
                this.state.getCurrentReceipt().toString()
        );
        return this;
    }
}
