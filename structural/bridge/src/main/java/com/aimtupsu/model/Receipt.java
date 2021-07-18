package com.aimtupsu.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Receipt {

    private final int number;
    private final String customerName;
    private final String customerEmail;
    private final List<Position> positionList;

}
