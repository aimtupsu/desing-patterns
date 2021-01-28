package com.aimtupsu.coffeemachine.handler;

import lombok.Getter;
import lombok.experimental.UtilityClass;

@Getter
@UtilityClass
public class HandlerFactory {

    private static final CoffeeHandler COFFEE_HANDLER = new CoffeeHandler();
    private static final CupHandler CUP_HANDLER = new CupHandler();
    private static final MilkHandler MILK_HANDLER = new MilkHandler();
    private static final SugarHandler SUGAR_HANDLER = new SugarHandler();
    private static final WaterHandler WATER_HANDLER = new WaterHandler();
    private static final FinishHandler FINISH_HANDLER = new FinishHandler();

    public static CoffeeHandler getCoffeeHandler() {
        return COFFEE_HANDLER;
    }

    public static CupHandler getCupHandler() {
        return CUP_HANDLER;
    }

    public static MilkHandler getMilkHandler() {
        return MILK_HANDLER;
    }

    public static SugarHandler getSugarHandler() {
        return SUGAR_HANDLER;
    }

    public static WaterHandler getWaterHandler() {
        return WATER_HANDLER;
    }

    public static FinishHandler getFinishHandler() {
        return FINISH_HANDLER;
    }

}
