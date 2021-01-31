package com.aimtupsu.machinegun;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Kpvt implements MachineGun {

    @Override
    public void shoot() {
       log.info("Выполнен выстрел из крупнокалиберного пулемёта Владимирова.");
    }

    @Override
    public String getName() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Крупнокалиберный пулемёт Владимирова танковый";
    }

}