package com.aimtupsu;

import com.aimtupsu.combatvehicle.btr80.Btr80;
import com.aimtupsu.crossbow.Crossbow;
import com.aimtupsu.crossbow.GiantCrossbow;
import com.aimtupsu.gunadapter.CrossbowToMachineGunAdapter;
import com.aimtupsu.machinegun.Kpvt;
import com.aimtupsu.machinegun.MachineGun;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AdapterDemo {

    public static void main(String[] args) {

        log.info("Создаём БТР-80");
        final Btr80 btr80 = new Btr80();

        log.info("Создаём пулемёт КПВТ");
        final MachineGun kpvt = new Kpvt();

        log.info("Устанавливаем КПВТ на БТР-80 и стреляем.");
        btr80.setGun(kpvt);
        btr80.go();
        btr80.fire();

        log.info("Создаём наш гигантский арбалет.");
        final Crossbow giantCrossbow = new GiantCrossbow();

        log.info("Создаём адаптер для установки нашего арбалета на БТР-80.");
        final CrossbowToMachineGunAdapter crossbowToMachineGunAdapter = new CrossbowToMachineGunAdapter(giantCrossbow);

        log.info("Устанавливаем адаптированный гигантский арбалет на БТР-80 и стреляем.");
        btr80.setGun(crossbowToMachineGunAdapter);
        btr80.go();
        btr80.fire();
    }

}
