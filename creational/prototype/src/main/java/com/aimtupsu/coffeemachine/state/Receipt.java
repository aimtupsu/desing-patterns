package com.aimtupsu.coffeemachine.state;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString(of = { "name" })
public enum Receipt {

    CAPPUCCINO(
            Quantity.getQuantityInGram(50),
            Quantity.getQuantityInMilliliter(100),
            Quantity.getQuantityInMilliliter(100),
            "Капуччино"
    ),
    LATTE(
            Quantity.getQuantityInGram(50),
            Quantity.getQuantityInMilliliter(100),
            Quantity.getQuantityInMilliliter(100),
            "Латте"
    ),
    AMERICANO(
            Quantity.getQuantityInGram(100),
            Quantity.getQuantityInMilliliter(200),
            Quantity.ZERO_MILLI,
            "Американо"
    ),
    ESPRESSO(
            Quantity.getQuantityInGram(50),
            Quantity.getQuantityInMilliliter(300),
            Quantity.ZERO_MILLI,
            "Эспрессо"
    );


    private final Quantity coffee;
    private final Quantity water;
    private final Quantity milk;
    private final String name;

}
