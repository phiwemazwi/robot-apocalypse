package tech.ioco.robot.apocalypse.Service;

import tech.ioco.robot.apocalypse.Entity.Survivor;

public interface SurvivorService {
    Survivor addSurvivor(Survivor survivor);
    Survivor updateSurvivorLocation(Long id, double latitude,double longitude);
}
