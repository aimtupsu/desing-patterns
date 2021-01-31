package com.aimtupsu.coffeemachine.handler;

import lombok.experimental.UtilityClass;

@UtilityClass
public class HandlerFactory {

    private final CoffeeHandler COFFEE_HANDLER = new CoffeeHandler();
    private final CupHandler CUP_HANDLER = new CupHandler();
    private final MilkHandler MILK_HANDLER = new MilkHandler();
    private final SugarHandler SUGAR_HANDLER = new SugarHandler();
    private final WaterHandler WATER_HANDLER = new WaterHandler();
    private final FinishHandler FINISH_HANDLER = new FinishHandler();
    private final CompositeHandler PREPARATION_HANDLER = createPreparationHandler();

    public Handler getPreparationHandler() {
        return PREPARATION_HANDLER;
    }

    public Handler getSugarHandler() {
        return SUGAR_HANDLER;
    }

    public Handler getFinishHandler() {
        return FINISH_HANDLER;
    }

    private CompositeHandler createPreparationHandler() {
        final CompositeHandler preparationHandler = new CompositeHandler();
        preparationHandler.addHandler(COFFEE_HANDLER);
        preparationHandler.addHandler(WATER_HANDLER);
        preparationHandler.addHandler(MILK_HANDLER);
        preparationHandler.addHandler(CUP_HANDLER);
        return preparationHandler;
    }

}
