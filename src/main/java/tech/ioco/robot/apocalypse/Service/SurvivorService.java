package tech.ioco.robot.apocalypse.Service;

import tech.ioco.robot.apocalypse.Entity.Survivor;

import java.util.List;

public interface SurvivorService {
    Survivor addSurvivor(Survivor survivor);
    Survivor updateSurvivorLocation(Long id, double latitude,double longitude);


    double getInfectedPercentage();
    double getNonInfectedPercentage();
    List<Survivor> getInfected();
    List<Survivor> getNoneInfected();
}
