package com.aimtupsu.coffeemachine.instruction;

import com.aimtupsu.coffeemachine.handler.Handler;
import com.aimtupsu.coffeemachine.handler.HandlerFactory;
import com.aimtupsu.coffeemachine.state.Receipt;
import com.aimtupsu.coffeemachine.state.State;
import java.util.Map;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InstructionFactory {

    private static final Map<Integer, Receipt> RECEIPT_MAP = Map.of(
            1, Receipt.CAPPUCCINO,
            2, Receipt.LATTE,
            3, Receipt.AMERICANO,
            4, Receipt.ESPRESSO
    );

    public Instruction getStartInstruction(final State state) {
        final Handler preparationHandler = HandlerFactory.getPreparationHandler();
        return new StartInstruction(RECEIPT_MAP, preparationHandler, state);
    }

    public Instruction getSugarInstruction(final State state) {
        final Handler sugarHandler = HandlerFactory.getSugarHandler();
        return new SugarInstruction(sugarHandler, state);
    }

    public Instruction getEndInstruction(final State state) {
        final Handler finishHandler = HandlerFactory.getFinishHandler();
        return new EndInstruction(finishHandler, state);
    }

}
