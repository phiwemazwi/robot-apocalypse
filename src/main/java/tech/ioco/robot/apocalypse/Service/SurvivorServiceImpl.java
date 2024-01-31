package tech.ioco.robot.apocalypse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ioco.robot.apocalypse.Entity.Survivor;
import tech.ioco.robot.apocalypse.Repository.SurvivorRepo;

@Service
public class SurvivorServiceImpl implements SurvivorService{

    private final SurvivorRepo survivorRepo;

    @Autowired
    public SurvivorServiceImpl(SurvivorRepo survivorRepo){
        this.survivorRepo = survivorRepo;
    }

    @Override
    public Survivor addSurvivor(Survivor survivor){
        return  survivorRepo.save(survivor);
    }
}
