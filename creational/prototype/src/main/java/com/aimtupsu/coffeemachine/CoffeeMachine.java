package com.aimtupsu.coffeemachine;

import com.aimtupsu.coffeemachine.handler.exception.HandleException;
import com.aimtupsu.coffeemachine.instruction.Instruction;
import com.aimtupsu.coffeemachine.instruction.StartInstruction;
import com.aimtupsu.coffeemachine.state.State;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class CoffeeMachine {

    private final State state;
    private Instruction instruction;

    public void start() {
        if (this.instruction == null) {
            final State currentState = this.getState();
            final Instruction instruction = new StartInstruction(currentState);
            this.instruction = instruction;
            instruction.showMessage();
        }
    }

    public void inputData(final int data) {
        if (this.instruction != null) {
            this.instruction.inputData(data);
        }
    }

    public void next() {
        if (this.instruction != null) {
            try {
                this.instruction = instruction.next();
                if (this.instruction.getState().isReady()) {
                    this.finish();
                } else {
                    this.instruction.showMessage();
                }
            } catch (HandleException e) {
                log.error("[Coffee Machine] - Ошибка приготовления напитка: {}.", e.getMessage(), e);
                this.cancel();
            }
        }
    }

    public void cancel() {
        if (this.instruction != null) {
            this.instruction = null;
        }
    }


    public State getState() {
        try {
            return this.state.clone();
        } catch (CloneNotSupportedException e) {
            log.error("State getting is failed.", e);
            return null;
        }
    }

    private void finish() {
        this.state.updateState(this.instruction.getState());
        this.instruction = null;
    }

}
