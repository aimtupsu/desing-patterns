package com.aimtupsu.bankclient.model;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PositionInfo {

    private final ItemInfo itemInfo;
    private final BigDecimal price;

    @Data
    @Builder
    public static class ItemInfo {

        private final int number;
        private final String name;

    }
}
