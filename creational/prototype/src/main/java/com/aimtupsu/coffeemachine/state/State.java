package com.aimtupsu.coffeemachine.state;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class State implements Cloneable {

    private Quantity coffee;
    private Quantity water;
    private Quantity milk;
    private Quantity sugar;
    private Quantity cup;

    @Setter
    private Receipt currentReceipt = null;
    @Setter
    private Quantity currentSugar = Quantity.ZERO_GRAM;
    @Setter
    private boolean isReady = false;
    @Setter
    private String message = null;


    public State(final Quantity coffee,
                 final Quantity water,
                 final Quantity milk,
                 final Quantity sugar,
                 final Quantity cup) {
        this.coffee = coffee;
        this.water = water;
        this.milk = milk;
        this.sugar = sugar;
        this.cup = cup;
    }

    public State clone() throws CloneNotSupportedException {
        super.clone();
        return new State(
                Quantity.clone(this.coffee),
                Quantity.clone(this.water),
                Quantity.clone(this.milk),
                Quantity.clone(this.sugar),
                Quantity.clone(this.cup)
        );
    }

    public void updateState(final State state) {
        this.coffee = state.getCoffee();
        this.water = state.getWater();
        this.milk = state.getMilk();
        this.sugar = state.getSugar();
        this.cup = state.getCup();
    }

}
