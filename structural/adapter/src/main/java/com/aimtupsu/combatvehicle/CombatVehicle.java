package com.aimtupsu.combatvehicle;

import com.aimtupsu.machinegun.MachineGun;

public interface CombatVehicle {

    void dropGun();

    void setGun(MachineGun gun);

    void go();

    void fire();

}
