package com.aimtupsu.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Position {

    private final int positionNumber;
    private final int itemNumber;
    private final String itemName;
    private final BigDecimal price;

}
