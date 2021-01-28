package com.aimtupsu.coffeemachine.state;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Quantity implements Cloneable {

    public static final Quantity ZERO_GRAM = new Quantity(0, QuantityType.GRAM);
    public static final Quantity ZERO_MILLI = new Quantity(0, QuantityType.MILLILITER);
    public static final Quantity ZERO_PIECE = new Quantity(0, QuantityType.PIECE);

    private long quantity;
    private final QuantityType quantityType;

    public enum QuantityType {
        MILLILITER,
        GRAM,
        PIECE
    }

    public static Quantity getQuantityInGram(final long quantity) {
        return new Quantity(quantity, QuantityType.GRAM);
    }

    public static Quantity getQuantityInMilliliter(final long quantity) {
        return new Quantity(quantity, QuantityType.MILLILITER);
    }

    public static Quantity getQuantityInPieces(final long quantity) {
        return new Quantity(quantity, QuantityType.PIECE);
    }

    public static Quantity clone(final Quantity quantity) {
        return new Quantity(quantity.getQuantity(), quantity.getQuantityType());
    }

    public void decrease(final Quantity quantity) {
        this.decrease(quantity.getQuantity());
    }

    public void decrease(final long quantity) {
        this.quantity -= quantity;
    }

}
