package com.aimtupsu.gunadapter;

import com.aimtupsu.crossbow.Crossbow;
import com.aimtupsu.machinegun.MachineGun;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@Data
public class CrossbowToMachineGunAdapter implements MachineGun {

    private Crossbow crossbow;

    @Override
    public void shoot() {
        crossbow.shoot();
    }

    @Override
    public String getName() {
        return crossbow.toString();
    }

}
