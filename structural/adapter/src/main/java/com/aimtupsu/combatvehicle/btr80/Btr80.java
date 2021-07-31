package com.aimtupsu.combatvehicle.btr80;

import com.aimtupsu.combatvehicle.CombatVehicle;
import com.aimtupsu.machinegun.MachineGun;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Btr80 implements CombatVehicle {

    private MachineGun machineGun;

    @Override
    public void dropGun() {
        log.info("Оружее {} снято.", machineGun.getName());
        this.machineGun = null;
    }

    @Override
    public void setGun(MachineGun gun) {
        log.info("Установлено новое оружие {}", gun.getName());
        this.machineGun = gun;
    }

    @Override
    public void go() {
        log.info("БТР-80 едет.");
    }

    @Override
    public void fire() {
        log.info("Подготовка к выстрелу из оружия {}", machineGun.getName());
        machineGun.shoot();
    }

}
